package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;
import com.warmmingup.buildup.admin.service.UserManageService;
import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.Pagenation;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.common.paging.SelectCriteria;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserManageController {

    private final UserManageService userManagerService;

    public UserManageController(UserManageService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @GetMapping("/manage-users")
    public ResponseEntity<ResponseDTO> findAllUsers(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "search", defaultValue = "") String search) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> userManage = new HashMap<>();

        if (!"".equals(search)) {
            userManage.put("search", "%" + search + "%");
        }

        int totalCount = userManagerService.findUserTotalCount(userManage);
        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

        userManage.put("pageInfo", selectCriteria);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(userManagerService.findAllUsers(userManage));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    @GetMapping("/manage-users/{userNo}")
    public ResponseEntity<ResponseDTO> findUserInfo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", userManagerService.findUserInfo(userNo)));
    }

    @PostMapping("/manage-users")
    public ResponseEntity<?> insertUser(@RequestBody NewUserDTO newUser) {

        newUser.setPwd(newUser.getNo() + "");
        System.out.println(newUser);
        userManagerService.insertUser(newUser);

        return ResponseEntity.created(URI.create("/api/v1/manage-users/" + newUser.getNo())).build();
    }

    @PutMapping("/manage-users/{userNo}")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO modifyUser, @PathVariable int userNo) {

        Map<String, Object> modifyUserInfo = new HashMap<>();
        modifyUserInfo.put("oldNo", userNo);
        modifyUserInfo.put("no", modifyUser.getNo());
        modifyUserInfo.put("name", modifyUser.getName());
        modifyUserInfo.put("email", modifyUser.getEmail());
        modifyUserInfo.put("authority", modifyUser.getAuthority());

        userManagerService.updateUser(modifyUserInfo);

        return ResponseEntity.created(URI.create("/api/v1/manage-users/" + userNo)).build();
    }

    @DeleteMapping("/manage-users/{userNo}")
    public ResponseEntity<?> deleteUser(@PathVariable int userNo) {

        userManagerService.deleteUser(userNo);

        return ResponseEntity.noContent().build();
    }
}
