package com.example.demo.game.service;

import com.example.demo.game.service.request.CreateGameRequest;
import com.example.demo.game.service.response.CreateSimpleGameResponse;

public interface GameService {
    CreateSimpleGameResponse createSimpleGame(CreateGameRequest createGameRequest);
//    RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest gameRecordWinnerRequest);
//    CheckGameResponse checkGame(CheckGameRequest checkGameRequest);
}
