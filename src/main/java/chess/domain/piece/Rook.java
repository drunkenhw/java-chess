package chess.domain.piece;

import chess.domain.board.FileCoordinate;
import chess.domain.board.Position;
import chess.domain.board.RankCoordinate;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    private final boolean isMove;

    public Rook(Color color, boolean isMove) {
        super(color);
        this.isMove = isMove;
    }

    public Rook(Color color) {
        super(color);
        this.isMove = false;
    }

    @Override
    boolean canMove(Position sourcePosition, Position targetPosition) {
        return isStraight(sourcePosition, targetPosition) && isNotMyPosition(sourcePosition, targetPosition);
    }

    @Override
    List<Position> findPath(Position sourcePosition, Position targetPosition) {
        if (!canMove(sourcePosition, targetPosition)) {
            throw new IllegalArgumentException("이동할 수 없는 위치입니다.");
        }
        List<Position> paths = new ArrayList<>();
        int nowFileCoordinate = sourcePosition.getColumn();
        int nowRankCoordinate = sourcePosition.getRow();
        int targetFileCoordinate = targetPosition.getColumn();
        int targetRankCoordinate = targetPosition.getRow();
        if (nowFileCoordinate - targetFileCoordinate == 0) {
            int rowStep = getStep(nowRankCoordinate, targetRankCoordinate);

            while (nowRankCoordinate != targetRankCoordinate) {
                Position position = new Position(sourcePosition.getFileCoordinate(),
                        RankCoordinate.findBy(nowRankCoordinate));
                nowRankCoordinate += rowStep;
                paths.add(position);
            }
            return paths;
        }
        int columnStep = getStep(nowFileCoordinate, targetFileCoordinate);

        while (nowFileCoordinate != targetFileCoordinate) {
            Position position = new Position(FileCoordinate.findBy(nowFileCoordinate),
                    sourcePosition.getRankCoordinate());
            nowFileCoordinate += columnStep;
            paths.add(position);
        }
        return paths;
    }

    private int getStep(int nowFileCoordinate, int targetFileCoordinate) {
        if (nowFileCoordinate - targetFileCoordinate > 0) {
            return -1;
        }
        return 1;
    }

    @Override
    boolean isKing() {
        return false;
    }

    @Override
    Piece move() {
        return null;
    }
}
