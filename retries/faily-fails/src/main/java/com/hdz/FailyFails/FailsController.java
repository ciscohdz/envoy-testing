package com.hdz.FailyFails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Random;

@RestController
public class FailsController {

    @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "Teapot reasons")
    private static class TeaPotResponse extends RuntimeException {}

    @RequestMapping(value = "/maybe", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity loadStatus() {
        if( shouldFail() ) {
            System.out.println("Failing status");
            throw new TeaPotResponse();
        }
        return ResponseEntity.ok("hey it worked!");
    }

    private boolean shouldFail() {
        return new Random().nextBoolean();
    }

}
