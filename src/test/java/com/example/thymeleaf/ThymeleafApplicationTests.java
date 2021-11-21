package com.example.thymeleaf;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.Assert;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ThymeleafApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private BoardController boardController;

	@Test
	void contextLoads() throws Exception{
		assertThat(boardController).isNotNull();
	}

//	@Test
//	public void testBoards() throws Exception{
//		//Assert.hasText(this.restTemplate.getForObject("http://localhost:" + port + String.class, "boards"));
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + String.class)).contains("board");
//	}

	@Test
	void testWinMethods() {
		char[][] testBoard = new char[][]{
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', 'x', '.', '.'},
				{'.', '.', '.', '.', '.', 'x', '.', '.', '.'},
				{'.', '.', '.', '.', 'x', '.', '.', '.', '.'},
				{'.', '.', '.', 'x', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'}
		};
		GameLogic gameLogic = new GameLogic();
		Board board = new Board();
		gameLogic.board = board;
		gameLogic.board.setBoardArray(testBoard);
		gameLogic.lastRow = 1;
		gameLogic.lastColumn = 6;
		Assert.isTrue(gameLogic.isWin());

		testBoard = new char[][]{
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', 'x', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', 'x', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', 'x', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', 'x', '.', '.', '.'}
		};
		gameLogic.board.setBoardArray(testBoard);

		Assert.isTrue(gameLogic.isWin(), "");
		gameLogic.lastRow = 1;
		gameLogic.lastColumn = 1;
		testBoard = new char[][]{
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', '.', '.', '.', '.', '.', '.'}
		};
		gameLogic.board.setBoardArray(testBoard);
		gameLogic.lastRow = 1;
		gameLogic.lastColumn = 2;
		Assert.isTrue(gameLogic.isWin(), "");

		testBoard = new char[][]{
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', 'x', 'x', 'x', 'x', 'x', '.', '.'}
		};
		gameLogic.board.setBoardArray(testBoard);
		gameLogic.lastRow = 5;
		gameLogic.lastColumn = 6;
		Assert.isTrue(gameLogic.isWin(), "");

	}
}
