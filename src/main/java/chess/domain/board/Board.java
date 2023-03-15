package chess.domain.board;

import java.util.List;

public class Board {

    private final List<Rank> ranks;

    Board(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<Rank> getRanks() {
        return List.copyOf(ranks);
    }
}