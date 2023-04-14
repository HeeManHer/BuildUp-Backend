package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import com.warmmingup.buildup.admin.service.AuthorityManageService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AuthorityManageController {

    private final AuthorityManageService authorityManageService;

    public AuthorityManageController (AuthorityManageService authorityManageService) {
        this.authorityManageService = authorityManageService;
    }

    @GetMapping("/manage-auths")
    public ResponseEntity<ResponseDTO> getAuthority () {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", authorityManageService.findAuthority()));
    }

    @GetMapping("/manage-auths/roles")
    public ResponseEntity<ResponseDTO> getAuthRole () {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", authorityManageService.findAuthRole()));
    }

    @GetMapping("/manage-auths/types")
    public ResponseEntity<ResponseDTO> getAuthType () {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", authorityManageService.findAuthType()));
    }

    @PostMapping("/auths")
    public ResponseEntity<?> registAuthority (@RequestBody AuthorityDTO auth) {

        authorityManageService.registAuthority(auth);

        return ResponseEntity.created(URI.create("/api/v1/auths/" + auth.getRoleNo())).build();
    }

    @PutMapping("/auths")
    public ResponseEntity<?> updateAuthority (@RequestBody List<AuthorityDTO> auth) {
        System.out.println(auth);
        authorityManageService.updateAuthority(auth);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/auths/{roleNo}")
    public ResponseEntity<?> deleteAuthority (@PathVariable int roleNo) {
        authorityManageService.deleteAuthority(roleNo);

        return ResponseEntity.noContent().build();
    }

}
