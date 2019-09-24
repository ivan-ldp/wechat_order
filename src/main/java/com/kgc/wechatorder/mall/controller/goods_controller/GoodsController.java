package com.kgc.wechatorder.mall.controller.goods_controller;

import com.kgc.wechatorder.mall.pojo.Goods;
import com.kgc.wechatorder.mall.pojo.GoodsCategory;
import com.kgc.wechatorder.mall.pojo.Status;
import com.kgc.wechatorder.mall.service.GoodsCategoryService;
import com.kgc.wechatorder.mall.service.GoodsService;
import com.kgc.wechatorder.mall.service.StatusService;
import com.kgc.wechatorder.sys.pojo.Admin;
import com.kgc.wechatorder.tools.Constants;
import com.kgc.wechatorder.tools.PageSupport;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    private Logger logger = Logger.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsCategoryService goodsCategoryService;
    @Resource
    private StatusService statusService;
    private Goods goods;
    private GoodsCategory goodsCategory;
    Logger log = Logger.getLogger("GoodsController.class");

    /*            获取商品分类列表     */

    @ResponseBody
    @RequestMapping("/sortList")
    public List<GoodsCategory> getSortList() {
        return goodsCategoryService.findAllGoodsCategory();
    }

    /*      获取商品状态  */
    @ResponseBody
    @RequestMapping("/statusList")
    public List<Status> statusList() {
        List<Status> statusList = statusService.getStatuslist("Goods_Status");
        return statusList;
    }

    /*            进入goods分类列表页面     */
    @RequestMapping("/toGoodsSortList")
    public String toGoodsSortList() {
        return "classify";
    }


    /*            删除商品分类        */

    @RequestMapping("/sortList/{sortId}")
    public String del(@PathVariable("sortId") Integer sortId, Model model) {
        int count = goodsCategoryService.delete(sortId);
        System.out.println("+++++++++++++++++++++=" + count);
        if (count > 0) {
            return "classify";
        } else {
            model.addAttribute("message", Constants.FILEDSHANCHU);
            return "classify";
        }
    }

    /*            增加商品分类        */
    @RequestMapping("/sortadd")
    public String addSortList(@ModelAttribute("goodsCategory") GoodsCategory goodsCategory) {
        return "insertClassify";
    }

    /*            保存商品分类        */
    @RequestMapping("/sortaddSave")
    public String addSortSave(@ModelAttribute("goodsCategory") GoodsCategory goodsCategory, HttpSession session,
                              HttpServletRequest request, @RequestParam(value = "a_idPicPath", required = false) MultipartFile attach) {
//        String idPicPath = null;
//        //判断文件是否为空
//        if (!attach.isEmpty()) {
//            String path = request.getSession().getServletContext().getRealPath("static" + File.separator + "uploadfiles");
//            logger.info("uploadFile path ============== > " + path);
//            String oldFileName = attach.getOriginalFilename();//原文件名
//            logger.info("uploadFile oldFileName ============== > " + oldFileName);
//            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
//            logger.debug("uploadFile prefix============> " + prefix);
//            int filesize = 500000;
//            logger.debug("uploadFile size============> " + attach.getSize());
//            if (attach.getSize() > filesize) {//上传大小不得超过 500k
//                request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
//                return "goodsSort_add";
//            } else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
//                    || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {//上传图片格式不正确
//                String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1, 100000) + "_Personal.jpg";
//                logger.debug("new fileName======== " + attach.getName());
//                File targetFile = new File(path, fileName);
//                if (!targetFile.exists()) {
//                    targetFile.mkdirs();
//                }
//                //保存
//                try {
//                    attach.transferTo(targetFile);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    request.setAttribute("uploadFileError", " * 上传失败！");
//                    return "/goods/goodsSort_add";
//                }
//                idPicPath = path + File.separator + fileName;
//            } else {
//                request.setAttribute("uploadFileError", " * 上传图片格式不正确");
//                return "/goods/goodsSort_add";
//            }
//        }

        goodsCategory.setCreateTime(new Date());
        //  goodsCategory.setPicUrl(idPicPath);
        if (goodsCategoryService.add(goodsCategory) > 0) {
            return "classify";
        }
        return "insertClassify";
    }

    /*            修改商品分类        */
    @RequestMapping("/modifyGoodsSort/{sortId}")
    public String sortModify(@PathVariable("sortId") Integer sortId, Model model) {
        goodsCategory = goodsCategoryService.findGoodsCategory(sortId);
        model.addAttribute("goodsCategory", goodsCategory);
        return "/goods/goodsSort_modify";
    }

    /*            修改商品分类保存       */
    @RequestMapping("/modifyGoodsSortSave")
    public String sortModifySave(@ModelAttribute("goodsCategory") GoodsCategory goodsCategory, Model model) {
        System.out.println(goodsCategory.toString() + "12333333333333333333");
        int count = goodsCategoryService.modify(goodsCategory);
        System.out.println("+++++++++++++++++++++++++=" + count);
        if (count > 0) {
            return "/goods/goodsSort_list";
        }
        model.addAttribute("message", Constants.FILEDMODIFY);
        return "goodsSort_modify";
    }

    /*     进入商品列表  */
    @RequestMapping("/toGoodsList")
    public String toGoodsList() {
        return "goods/goods_list";
    }

    /*            增加商品        */
    @RequestMapping("/goodsAdd")
    public String addGoods(@ModelAttribute("goods") Goods goods) {
        return "insertCommodity";
    }

    /*            增加商品保存       */
    @RequestMapping("/goodsAddSave")
    public String addGoodsSave(@ModelAttribute("goods") Goods goods, HttpSession session,
                               HttpServletRequest request, @RequestParam(value = "a_idPicPath", required = false) MultipartFile attach) throws IOException {
        String proPath= System.getProperty("user.dir");
        System.out.println("根目录是++++++++++++"+proPath);

        //获取根classess目录
       File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        ApplicationHome home = new ApplicationHome(getClass());
//        File sysfile = home.getSource();
//        String jarPath = sysfile.getParentFile().toString();
        String absolutePath = path.getAbsolutePath();
        File upload = new File(path.getAbsolutePath(),"static/upload/imgs");
        System.out.println(upload.getPath());
        String fileName = null;
        //String idPicPath = null;
        //判断文件是否为空
        if (!attach.isEmpty()) {
//            String path = request.getSession().getServletContext().getRealPath("static" + File.separator + "uploadfiles");
//            logger.info("uploadFile path ============== > " + path);
            String oldFileName = attach.getOriginalFilename();//原文件名
            logger.info("uploadFile oldFileName ============== > " + oldFileName);
            String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
            logger.debug("uploadFile prefix============> " + prefix);
            int filesize = 500000;
            logger.debug("uploadFile size============> " + attach.getSize());
            if (attach.getSize() > filesize) {//上传大小不得超过 500k
                request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
                return "goodsSort_add";
            } else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {//上传图片格式不正确
                fileName = System.currentTimeMillis() + RandomUtils.nextInt(1, 100000) + "_Personal.jpg";
                logger.debug("new fileName======== " + attach.getName());
                File filePath = new File(proPath,"src/main/resources/static/upload/imgs/");
                logger.info("uploadFile path ============== > " + filePath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                attach.transferTo(new File(upload,fileName));

            } else {
                request.setAttribute("uploadFileError", " * 上传图片格式不正确");
                return "insertCommodity";
            }
        }

        goods.setCreateTime(new Date());
        goods.setPicUrl(fileName);
        if (goodsService.add(goods) > 0) {
            return "redirect:/goods/goodsList";
        }
        return "insertCommodity";
    }

    /*            凭借商品种类获取商品列表  使用ajax传值   */
    @ResponseBody
    @RequestMapping(value = "/goodsList2", method = RequestMethod.POST)
    public List<Goods> goodsList2(Model model,
                                  @Param("categoryId") Integer categoryId
    ) {
        //获取商品列表
        List<Goods> list2 = goodsService.findGoodsListById1(categoryId);
        return list2;
    }

    /*            获取商品列表  使用页面传值   */
//    @ResponseBody
//    List<Goods> goodsList
    @RequestMapping(value = "/goodsList")
    public String goodsList(Model model, HttpSession session,
                            @RequestParam(value = "goodsName", required = false) String goodsName,
                            @RequestParam(value = "status", required = false) String status,
                            @RequestParam(value = "categoryId", required = false) String categoryId
    ) {
//        int pageSizes = Constants.pageSize;
//        String pageIndex = "1";
        Integer status2 = null;
        if (status != null && !status.equals("")) {
            status2 = Integer.parseInt(status);
        } else {
            status2 = null;
        }
        Integer categoryId2 = null;
        if (categoryId != null && !categoryId.equals("")) {
            categoryId2 = Integer.parseInt(categoryId);
        } else {
            categoryId2 = null;
        }
//        //当前页码
//        Integer currentPageNo = 1;
//        if (pageIndex != null) {
//            try {
//                currentPageNo = Integer.valueOf(pageIndex);
//            } catch (NumberFormatException e) {
//                // TODO: handle exception
//                e.printStackTrace();
//            }
//        }
//        int totalCount = goodsService.getGoodsCount(goodsName, status2, categoryId2);
//        PageSupport pages = new PageSupport();
//        pages.setCurrentPageNo(currentPageNo);
//        pages.setPageSize(pageSizes);
//        pages.setTotalCount(totalCount);
//        int totalPageCount = pages.getTotalPageCount();
//        //控制首页和尾页
//        if (currentPageNo < 1) {
//            currentPageNo = 1;
//        } else if (currentPageNo > totalPageCount) {
//            currentPageNo = totalPageCount;
//        }
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.findAllGoodsCategory();
        //获取商品列表
        List<Goods> list = goodsService.findGoodsListById2(goodsName, status2, categoryId2);
        System.out.println("+++++++++++++++++++++++++++++++++++++++" + list);
        session.setAttribute("list", list);
        session.setAttribute("goodsCategoryList", goodsCategoryList);
        List<Status> statusList = statusService.getStatuslist("Goods_Status");
        session.setAttribute("statusList", statusList);
        return "design";
    }
    /*            修改商品列表          */

    @RequestMapping("/modify/{goodsId}")
    public String modifyGoods(@PathVariable("goodsId") int goodsId, HttpSession session, Model model) {
        goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("goods", goods);
        return "goods/goodsSort_modify";

    }

    /*            修改商品保存列表          */

    @RequestMapping("/modifySave")
    public String modifyGoods(@ModelAttribute("goods") Goods goods, Model model) {
        goods.setUpdateTime(new Date());
        int count = goodsService.modify(goods);
        if (count > 0) {
            model.addAttribute("message", "您修改成功");
            return "goods/goods_list";
        }
        return "goods/goods_modify";
    }
    /*            删除商品      */

    @RequestMapping("/delGoods/{goodsId}")
    public String delGoods(@PathVariable("goodsId") Integer goodsId, Model model) {
        int count = goodsService.deleteGoodsById(goodsId);
        System.out.println("+++++++++++++++++++++=" + count);
        if (count > 0) {
            return "redirect:/goods/goodsList";
        } else {
            model.addAttribute("message", Constants.FILEDSHANCHU);
            return "design";
        }
    }

    /*            修改商品       */
    @RequestMapping("/modifyGoods/{goodsId}")
    public String goodsModify(@PathVariable("goodsId") Integer goodsId, Model model) {
        goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("goods", goods);
        return "goods/goods_modify";
    }
    /*            增加商品      */

    @RequestMapping("/addGoods")
    public String addGoods() {
        return "goods/goods_add";
    }
    /*            增加商品保存     */

    public String addGoodsSave(HttpSession session, Model model) {
        int uid = ((Admin) session.getAttribute(Constants.USER_SESSION)).getAdminId();
        goods.setCreateTime(new Date());
        int count = goodsService.modify(goods);
        if (count > 0) {
            model.addAttribute("message", "您增加成功！！");
            return "goods/goods_list";
        }
        return "goods/goods_add";
    }
}
