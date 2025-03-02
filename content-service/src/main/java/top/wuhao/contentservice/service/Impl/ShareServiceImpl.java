package top.wuhao.contentservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.stereotype.Service;
import top.wuhao.contentservice.entity.Share;
import top.wuhao.contentservice.mapper.ShareMapper;
import top.wuhao.contentservice.service.ShareService;

@Service

public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {
}
