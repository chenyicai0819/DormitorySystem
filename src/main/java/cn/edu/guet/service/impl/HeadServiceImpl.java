package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Photo;
import cn.edu.guet.mapper.HeadMapper;
import cn.edu.guet.service.IHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.service.impl
 * @date 2021/7/21 15:10
 * @since 1.0
 */

@Service
public class HeadServiceImpl implements IHeadService {

    @Autowired
    public HeadMapper headMapper;

    public String addImage(Photo photo,int id){
        Photo photo1= headMapper.selectImageById(id);
        if (photo1==null){
            System.out.println("首次设置头像");
            headMapper.insertImage(photo);
        }else {
            System.out.println("更新头像");
            headMapper.updateImage(photo);
        }

        return "ok";
    }

    public String getImage(Integer id, HttpServletResponse response){
        try {
            Photo photo = headMapper.selectImageById(id);
            byte[] image = (byte[])photo.getImage();
            String value = new String(image,"UTF-8");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(value);
            for(int i=0;i<bytes.length;i++){
                if(bytes[i]<0){
                    bytes[i]+=256;
                }
            }
            response.setContentType("image/jpeg");
            ServletOutputStream out = response.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "ok";
    }
}
