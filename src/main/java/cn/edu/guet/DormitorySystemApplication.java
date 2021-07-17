package cn.edu.guet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet
 * @date 2021/7/15 20:00
 * @since 1.0
 */

@SpringBootApplication
@MapperScan("cn.edu.guet.mapper")
public class DormitorySystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(DormitorySystemApplication.class, args);
    }
}
