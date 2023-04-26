package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import com.warmmingup.buildup.admin.service.AuthorityManageService;
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
public class AuthorityManageController {

    private final AuthorityManageService authorityManageService;

    public AuthorityManageController(AuthorityManageService authorityManageService) {
        this.authorityManageService = authorityManageService;
    }

    @GetMapping("/manage-auths")
    public ResponseEntity<ResponseDTO> getAllAuthority(@RequestParam(name = "page", defaultValue = "1") int page) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> userManage = new HashMap<>();

        int totalCount = authorityManageService.findAuthorityTotalCount();
        int limit = 4;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(authorityManageService.findAllAuthority(selectCriteria));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    @GetMapping("/manage-auths/{authNo}")
    public ResponseEntity<ResponseDTO> getAuthorityDetail(@PathVariable int authNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", authorityManageService.findAuthorityDetail(authNo)));
    }

    @GetMapping("/manage-auths/types")
    public ResponseEntity<ResponseDTO> getAuthType() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", authorityManageService.findAuthType()));
    }

    @PostMapping("/manage-auths")
    public ResponseEntity<?> insertAuthority(@RequestBody AuthorityDTO auth) {

        int authNo = authorityManageService.insertAuthority(auth);

        return ResponseEntity.created(URI.create("/api/v1/auths/" + authNo)).build();
    }

    @PutMapping("/manage-auths")
    public ResponseEntity<?> updateAuthority(@RequestBody AuthorityDTO auth) {
        authorityManageService.updateAuthority(auth);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/manage-auths/{roleNo}")
    public ResponseEntity<?> deleteAuthority(@PathVariable int roleNo) {
        authorityManageService.deleteAuthority(roleNo);

        return ResponseEntity.noContent().build();
    }
}
