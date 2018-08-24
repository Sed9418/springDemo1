package com.example.demo.controller;

import com.example.demo.model.Advertisment;
import com.example.demo.repository.AdvertismentRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Controller
@RequestMapping("/advertisment")
public class AdvertismentController {
    @Autowired
    AdvertismentRepository advertismentRepository;

    @Value("${springdemo.ad.pic.url}")
    private String adPicDir;

    @PostMapping("/add")
    public String add(@ModelAttribute Advertisment advertisment,
                      @RequestParam("image") MultipartFile multipartFile) {
        File dir = new File(adPicDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String picName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        try {
            multipartFile.transferTo(new File(dir, picName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        advertisment.setPicUrl(picName);
        advertisment.setDate(new Date());
        advertismentRepository.save(advertisment);
        return "redirect:/home";
    }

    @GetMapping(value = "/adImage")
    @ResponseBody
    public byte[] adImage(@RequestParam("picUrl") String picUrl) throws IOException {
        InputStream in = new FileInputStream(adPicDir + picUrl);
        return IOUtils.toByteArray(in);
    }

}
