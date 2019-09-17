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
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
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

    /*            获取商品分类列表     */

    @ResponseBody
    @RequestMapping("/sortList")
    public List<GoodsCategory> getSortList() {
        return goodsCategoryService.findAllGoodsCategory();
    }
    /*      获取商品状态  */
    @ResponseBody
    @RequestMapping("/statusList")
    public List<Status>statusList(){
        List<Status>statusList=statusService.getStatuslist("Goods_Status");
        return  statusList;
    }

    /*            进入goods_list页面     */
    @RequestMapping("/toGoodsSortList")
    public String toGoodsSortList() {
        return "goodsSort_list";
    }


    /*            删除商品分类        */

    @RequestMapping("/sortList/{sortId}")
    public String del(@PathVariable("sortId") Integer sortId, Model model) {
        int count = goodsCategoryService.delete(sortId);
        System.out.println("+++++++++++++++++++++=" + count);
        if (count > 0) {
            return "/goodsSort_list";
        } else {
            model.addAttribute("message", Constants.FILEDSHANCHU);
            return "/goodsSort_list";
        }
    }
    /*            增加商品分类        */
    @RequestMapping("/sortadd")
    public String addSortList(@ModelAttribute("goodsCategory") GoodsCategory goodsCategory) {
        return "goodsSort_add";
    }

    /*            保存商品分类        */
    @RequestMapping("/sortaddSave")
    public String addSortSave(@ModelAttribute("goodsCategory")GoodsCategory goodsCategory, HttpSession session,
             HttpServletRequest request, @RequestParam(value ="a_idPicPath", required = false) MultipartFile attach) {
        String idPicPath = null;
        //判断文件是否为空
        if(!attach.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("static" + File.separator + "uploadfiles");
            logger.info("uploadFile path ============== > " + path);
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
                String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1,100000) + "_Personal.jpg";
                logger.debug("new fileName======== " + attach.getName());
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                //保存
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    return "goodsSort_add";
                }
                idPicPath = path + File.separator + fileName;
            } else {
                request.setAttribute("uploadFileError", " * 上传图片格式不正确");
                return "goodsSort_add";
            }
        }

        goodsCategory.setCreateTime(new Date());
        goodsCategory.setPicUrl(idPicPath);
        if (goodsCategoryService.add(goodsCategory) > 0) {
            return "goodsSort_list";
        }
        return "goodsSort_add";
    }

    /*            修改商品分类        */
    @RequestMapping("/modifyGoodsSort/{sortId}")
    public String sortModify(@PathVariable("sortId") Integer sortId, Model model) {
        goodsCategory = goodsCategoryService.findGoodsCategory(sortId);
        model.addAttribute("goodsCategory", goodsCategory);
        return "goodsSort_modify";
    }

    /*            修改商品分类保存       */
    @RequestMapping("/modifyGoodsSortSave")
    public String sortModifySave( @ModelAttribute("goodsCategory") GoodsCategory goodsCategory,Model model) {
        System.out.println(goodsCategory.toString()+"12333333333333333333");
        int count=goodsCategoryService.modify(goodsCategory);
        System.out.println("+++++++++++++++++++++++++="+count);
        if(count>0){
            return "goodsSort_list";
        }
        model.addAttribute("message",Constants.FILEDMODIFY);
      return "goodsSort_modify";
    }

    /*     进入商品列表  */
    @RequestMapping("/toGoodsList")
    public String toGoodsList(){
        return "goods_list";
    }
    /*            增加商品        */
    @RequestMapping("/goodsAdd")
    public String addGoods(@ModelAttribute("goods") Goods goods) {
        return "goods_add";
    }
    /*            保存商品分类        */
    @RequestMapping("/goodsAddSave")
    public String addGoodsSave(@ModelAttribute("goods")Goods goods, HttpSession session,
                              HttpServletRequest request, @RequestParam(value ="a_idPicPath", required = false) MultipartFile attach) {
        String idPicPath = null;
        //判断文件是否为空
        if(!attach.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("static" + File.separator + "uploadfiles");
            logger.info("uploadFile path ============== > " + path);
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
                String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1,100000) + "_Personal.jpg";
                logger.debug("new fileName======== " + attach.getName());
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                //保存
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    return "goods_add";
                }
                idPicPath = path + File.separator + fileName;
            } else {
                request.setAttribute("uploadFileError", " * 上传图片格式不正确");
                return "goods_add";
            }
        }

        goods.setCreateTime(new Date());
        goods.setPicUrl(idPicPath);
        if (goodsService.add(goods) > 0) {
            return "goods_list";
        }
        return "goods_add";
    }
    /*            获取商品列表  以及分页信息      */
    @ResponseBody
    @RequestMapping(value = "/goodsList")
    public List<Goods> goodsList(Model model, HttpSession session,
                                @RequestParam(value = "goodsName", required = false ) String goodsName,
                                @RequestParam(value = "status", required = false) Integer status,
                                @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                @RequestParam(value = "pageIndex",defaultValue = "1") String pageIndex
                                 ) {
        int pageSizes = Constants.pageSize;
        //当前页码
        Integer currentPageNo = 1;
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
       int totalCount = goodsService.getGoodsCount(goodsName, status, categoryId);
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSizes);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        //获取商品列表
        List<Goods> list = goodsService.findGoodsListById2(goodsName, status, categoryId, currentPageNo, pageSizes);
        System.out.println("+++++++++++++++++++++++++++++++++++++++"+list);
        // session.setAttribute("list", list);
       // session.setAttribute("statusList",statusList);
        return list;
    }
    /*            修改商品列表          */

    @RequestMapping("/modify/{goodsId}")
    public String modifyGoods(@PathVariable("goodsId") int goodsId, HttpSession session, Model model) {
        goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("goods", goods);
        return "goodsSort_modify";

    }

    /*            修改商品保存列表          */

    @RequestMapping("/modifySave")
    public String modifyGoods(@ModelAttribute("goods")Goods goods, Model model) {
        goods.setUpdateTime(new Date());
        int count = goodsService.modify(goods);
        if (count > 0) {
            model.addAttribute("message", "您修改成功");
            return "goods_list";
        }
        return "goods_modify";
    }
    /*            删除商品      */

    @RequestMapping("/delGoods/{goodsId}")
    public String delGoods(@PathVariable("goodsId") Integer goodsId, Model model) {
        int count = goodsService.deleteGoodsById(goodsId);
        System.out.println("+++++++++++++++++++++=" + count);
        if (count > 0) {
            return "goods_list";
        } else {
            model.addAttribute("message", Constants.FILEDSHANCHU);
            return "goods_list";
        }
    }
    /*            修改商品       */
    @RequestMapping("/modifyGoods/{goodsId}")
    public String goodsModify(@PathVariable("goodsId") Integer goodsId, Model model) {
        goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("goods", goods);
        return "goods_modify";
    }
    /*            增加商品      */

    @RequestMapping("/addGoods")
    public String addGoods() {
        return "addGoods";
    }
    /*            增加商品保存     */

    public String addGoodsSave(HttpSession session, Model model) {
        int uid = ((Admin) session.getAttribute(Constants.USER_SESSION)).getAdminId();
        goods.setCreateTime(new Date());
        int count = goodsService.modify(goods);
        if (count > 0) {
            model.addAttribute("message", "您增加成功！！");
            return "goods/goodsList";
        }
        return "goods/addGoods";
    }
}
