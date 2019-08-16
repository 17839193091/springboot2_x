package com.hdf.springboot2_x.chapter9.controller;

import com.hdf.springboot2_x.chapter9.pojo.User;
import com.hdf.springboot2_x.chapter9.service.UserService;
import com.hdf.springboot2_x.chapter9.view.PdfExportService;
import com.hdf.springboot2_x.chapter9.view.PdfView;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-16 11:18
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    @ResponseBody
    public void showUser(@RequestBody User user) {
        System.out.println(user);
    }

    @GetMapping("/exportPdf")
    public ModelAndView exportPdf(String userName, String note) {
        List<User> users = userService.findUsers(userName, note);
        View view = new PdfView(exportService());
        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("users",users);
        return mv;
    }

    @SuppressWarnings("unchecked")
    private PdfExportService exportService() {
        return new PdfExportService() {
            @Override
            public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) {
                try {
                    //A4纸张
                    document.setPageSize(PageSize.A4);
                    //标题
                    document.addTitle("用户信息");
                    //换行
                    document.add(new Chunk("\n"));
                    //表格3列
                    PdfPTable table = new PdfPTable(3);
                    //单元格
                    PdfPCell cell = null;
                    //字体 （蓝色加粗）
                    Font f8 = new Font();
                    f8.setColor(Color.BLUE);
                    f8.setStyle(Font.BOLD);
                    //标题
                    cell = new PdfPCell(new Paragraph("id", f8));
                    //居中对齐
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph("user_name", f8));
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph("note", f8));
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                    //获取数据模型中的用户列表
                    List<User> users = (List<User>) model.get("users");
                    for (User user : users) {
                        document.add(new Chunk("\n"));
                        cell = new PdfPCell(new Paragraph(user.getId() + ""));
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(user.getUserName()));
                        table.addCell(cell);

                        String note = user.getNote() == null ? "" : user.getNote();
                        cell = new PdfPCell(new Paragraph(note));
                        table.addCell(cell);
                    }

                    //在文档中加入表格
                    document.add(table);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
