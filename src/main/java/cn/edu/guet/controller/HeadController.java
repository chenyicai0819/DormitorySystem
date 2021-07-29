package cn.edu.guet.controller;

import cn.edu.guet.bean.Photo;
import cn.edu.guet.service.IHeadService;
import cn.edu.guet.service.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.controller
 * @date 2021/7/21 15:09
 * @since 1.0
 */

@Controller
@CrossOrigin
public class HeadController {
    @Autowired
    private IHeadService headService;
    @Autowired
    private ITreeService treeService;

    @PostMapping("/addimage")
    public String addImage(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id, HttpServletRequest request, Model model) throws Exception{
        if(!file.isEmpty()){
            BASE64Encoder encoder = new BASE64Encoder();
            String image = encoder.encode(file.getBytes());
            Photo photo = new Photo();
            photo.setId(id);
            photo.setImage(image);
            headService.addImage(photo,id);
            request.setAttribute("tree",treeService.getAllTree());
        }
        return "index";
    }

    @GetMapping("/getimage")
    @ResponseBody
    public void getImage(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception{
        headService.getImage(id,response);
    }
}
