package com.michal.service.implement;

import com.michal.service.WaitlistService;
import org.springframework.beans.factory.annotation.Autowired;

public class WaitlistServiceBean implements WaitlistService {

    WaitlistService waitlistService;

    @Autowired
    public WaitlistServiceBean(final WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }



}
