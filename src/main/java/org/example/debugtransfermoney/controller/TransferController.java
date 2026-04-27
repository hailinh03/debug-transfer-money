package org.example.debugtransfermoney.controller;

import lombok.RequiredArgsConstructor;
import org.example.debugtransfermoney.dto.TransferRequest;
import org.example.debugtransfermoney.dto.TransferResult;
import org.example.debugtransfermoney.service.ITransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final ITransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResult> transfer(@Valid @RequestBody TransferRequest request) {
        TransferResult result = transferService.transfer(
                request.getFrom(), request.getTo(), request.getAmount());
        return ResponseEntity.ok(result);
    }

}