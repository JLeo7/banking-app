package com.immersive.bankingapp.resource;

import com.immersive.bankingapp.model.Movement;
import com.immersive.bankingapp.service.AccountService;
import com.immersive.bankingapp.service.MovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/movement")
public class MovementResource {
    private MovementService movementService;
    private AccountService accountService;

    public MovementResource(MovementService movementService, AccountService accountService) {
        this.movementService = movementService;
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Movement> save(@RequestBody Movement movement) {
        movement.setOriginAccount(accountService.findByAccountId(movement.getOriginAccount().getAccountId()));
        movement.setDestinationAccount(accountService.findByAccountId(movement.getDestinationAccount().getAccountId()));
        movement = this.movementService.save(movement);
        return new ResponseEntity<>(movement, HttpStatus.OK);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List> findAllByAccountId(@PathVariable int accountId) {
        List<Movement> movementList = this.movementService.findAllMovementsByAccount(accountId);
        return new ResponseEntity<>(movementList,HttpStatus.OK);
    }
}
