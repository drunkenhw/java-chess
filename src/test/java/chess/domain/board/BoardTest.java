package chess.domain.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.piece.PieceType;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class BoardTest {

    @Test
    void 보드를_생성한다() {
        Piece piece = new Piece(PieceType.BISHOP, Color.BLACK);
        Square square = new Square(FileCoordinate.C, piece);
        Rank rank = new Rank(RankCoordinate.ONE, List.of(square));
        Board board = new Board(List.of(rank));

        assertThat(board.getRanks()).containsExactly(rank);
    }

    @Test
    void 위치를_전달받아_칸을_반환한다() {
        Board board = BoardFactory.createBoard();
        FileCoordinate fileCoordinate = FileCoordinate.A;
        RankCoordinate rankCoordinate = RankCoordinate.ONE;

        Square square = board.findSquare(fileCoordinate, rankCoordinate);

        Piece piece = square.getPiece();
        assertAll(
                () -> assertThat(piece.getPieceType()).isEqualTo(PieceType.ROOK),
                () -> assertThat(piece.getColor()).isEqualTo(Color.WHITE)
        );
    }
}
