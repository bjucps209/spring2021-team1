package model;
class Player{
    State player = State.DRIVING;
    PlayerObserver observer;

    public Player(State Player){
        this.player = Player;
    }

    public void setObserver(PlayerObserver observer) {
        this.observer = observer;
    }
    
}
//     switch (State){
//         case1: State = State.JUMP;
//             break;
//         case2: State = State.SPEEDUP;
//             break;
//         case3: State = State.LEFT;
//             break;
//         case4: State = State.RIGHT;
//             break;
//         case5: State = State.DRIVING;
//             break;
        


//     }
// }
