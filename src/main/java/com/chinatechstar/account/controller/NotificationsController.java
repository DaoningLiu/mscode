package com.chinatechstar.notification.controller;

import com.chinatechstar.component.commons.result.ListResult;
import com.chinatechstar.component.commons.result.ResultBuilder;
import com.chinatechstar.file.service.FileService;
import com.chinatechstar.notification.entity.Notification;
import com.chinatechstar.notification.service.NotificationService;
import com.chinatechstar.notification.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private FileService fileService;

    /**
     * 新闻、常见问题、消息通知
     *
     * @param notificationVO 消息通知前端参数
     * @return
     */
    @GetMapping(path = "/queryNotifications")
    public ListResult<Object> queryNotifications(NotificationVO notificationVO) {
        List<Notification> data =notificationService.queryNotifications(notificationVO.getCurrentPage(), notificationVO.getPageSize(),
                notificationVO.getTitle(), notificationVO.getContent(), notificationVO.getType(), notificationVO.getPriority(), notificationVO.getPublisher(),
                null, notificationVO.getSorter(),notificationVO.getTypeStart (),notificationVO.getIds ());
        return ResultBuilder.buildListSuccess(data);
    }


    /**
     * 上传文件
     *
     * @param file       文件资源
     * @param id         用户ID
     * @param parentId   上级ID
     * @param uploadType 上传类型
     * @param fileType   文件类型
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/uploadFiles", consumes = { "multipart/form-data" })
    public ListResult<Object> uploadFiles(@RequestParam(name = "file", required = true) MultipartFile file, @RequestParam(name = "id", required = true) Long id,
                                         @RequestParam(name = "parentId", required = false) Long parentId, @RequestParam(name = "uploadType", required = false) String uploadType,
                                         @RequestParam(name = "fileType", required = false) String fileType) throws Exception {
        String url = fileService.uploadFile(file, id, parentId, uploadType, fileType);
        return ResultBuilder.buildListSuccess(url);
    }

}
