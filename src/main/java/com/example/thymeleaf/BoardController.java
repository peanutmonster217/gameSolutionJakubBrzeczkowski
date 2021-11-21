package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    Person user1 = new Person("User 1", 'x');
    Person user2 = new Person("User 2", 'o');
    Person currentTurn = user1;
    Person winner;
    Board board;
    GameLogic gameLogic;

    @GetMapping("/board")
    String getBoards(Model model){
        if(board == null) {
            board = new Board(6, 9);
            board.setUpBoard();
        }
        model.addAttribute("board", board.getBoardArray());
        model.addAttribute("person1", user1);
        model.addAttribute("person2", user2);
        model.addAttribute("currentPerson", currentTurn);
        model.addAttribute("gameLogic", new GameLogic());
        return "boards";
    }

    @GetMapping("/showboard")
    String showBoard(Model model){
        model.addAttribute("board", board.getBoardArray());
        return "showboard";
    }

    @GetMapping("/droptoken")
    String dropToken(GameLogic gamelogic, Model model){
        this.gameLogic = gamelogic;
        gameLogic.board = board;
        gameLogic.addPiece(currentTurn, gamelogic.getColumn());
        if(gameLogic.isWin() == true){
            winner = currentTurn;
            model.addAttribute("winner",winner);
            return "winnerpage";
        }
        if(currentTurn == user1){
            currentTurn = user2;
        } else if(currentTurn == user2){
            currentTurn = user1;
        }
        return "showboard";
    }
}
