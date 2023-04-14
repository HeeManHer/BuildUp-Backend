package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.service.UserManagerService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserManageController {

    private final UserManagerService userManagerService;

    public UserManageController (UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @GetMapping("/manage-users")
    public ResponseEntity<ResponseDTO> findAllUsers (@RequestParam(name = "offset", defaultValue = "0") int offset, @RequestParam(name = "search", defaultValue = "") String search) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int limit = 10;

        String startUser = offset * limit + 1 + "";
        String endUser = (offset + 1) * limit + "";

        Map<String, String> userManage = new HashMap<>();
        userManage.put("start", startUser);
        userManage.put("end", endUser);
        if (!"".equals(search)) {
            System.out.println("%" + search + "%");
            userManage.put("search", "%" + search + "%");
        }

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", userManagerService.findAllUsers(userManage)));
    }

    @PostMapping("/manage-users")
    public ResponseEntity<?> insertUser (@RequestBody NewUserDTO newUser) {

        newUser.setPwd((newUser.getNo() + "").substring(4));

        userManagerService.insertUser(newUser);

        return ResponseEntity.created(URI.create("/api/v1/manage-users/" + newUser.getNo())).build();
    }

    @PutMapping("/manage-users")
    public ResponseEntity<?> updateUser (@RequestBody List<Integer> userNoList) {

        userManagerService.updateUser(userNoList);

        return ResponseEntity.created(URI.create("/api/v1/manage-users")).build();
    }

    @DeleteMapping("/manage-users/{userNo}")
    public ResponseEntity<?> deleteUser (@PathVariable int userNo) {

        userManagerService.deleteUser(userNo);

        return ResponseEntity.noContent().build();
    }
}
