package top.wuhao.contentservice.controller;





import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.wuhao.contentservice.Client.UserFeignClient;
import top.wuhao.contentservice.VO.AuthorVO;

import top.wuhao.contentservice.dto.UserDTO;

@RestController
public class ContentController2 {

    private final UserFeignClient userFeignClient;

    public ContentController2(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    /**
     * 通过用户ID获取作者的简要信息（id、姓名、头像URL）
     * 调用user-service通过Feign获取用户数据，并将其映射到AuthorVO对象中返回
     *
     * @param id 用户的ID
     * @return AuthorVO 包含用户ID、姓名、头像URL
     */
    @GetMapping("/author/{id}")
    public AuthorVO getAuthor(@PathVariable int id) {
        // 通过 Feign 客户端调用 user-service 获取用户信息
        UserDTO userDTO = userFeignClient.getUserById(id);

        // 打印获取到的 UserDTO 数据
        System.out.println("获取到的 UserDTO: " + userDTO);

        // 手动映射到 AuthorVO
        AuthorVO authorVO = new AuthorVO();
        authorVO.setId(userDTO.getId());
        authorVO.setUser_name(userDTO.getUserName());
        authorVO.setAvatar_url(userDTO.getAvatarUrl());

        // 打印映射后的 AuthorVO 数据
        System.out.println("映射后的 AuthorVO: " + authorVO);

        return authorVO; // 返回 AuthorVO
    }
}

