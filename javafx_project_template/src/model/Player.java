package model;
class Player{
    //how the player begins (in the middle lane moving forward)
    int speed = 0;
    int lives = 3;
    int score = 0;
    State player = State.MOVING;

    //x and y coordinate
    int x;
    int y;

    //
    public Player(State Player, int x, int y){
        this.player = Player;
        Coordinate coor = new Coordinate(x, y);

    }

    // {
    // switch (State){
    //     case 1: State = State.JUMP;
    //         break;
    //         //jumpUp()
    //     case 2: State = State.SPEEDUP;
    //         break;
    //         //speedUp();
    //     case 3: State = State.LEFT;
    //         break;
    //     case 4: State = State.RIGHT;
    //         break;
    //     case 5: State = State.MOVING;
    //         break;
    // }
    // }

    /**
     * @return none
     * @param int:x
     * @param int:y
     */
    public void jumpUp(){
        // break;
    }

    /**
     * @return none 
     * @param none
     * make the view go faster meaning adding more in x over a faster period of times
     */
    public void speedUp(){
        // break;
    }

    /**
     * @return none
     * @param State:state
     * changing lanes to the left: if its already left by gettingcurrentstate then dont move the y; if the player is on
     * the right or the middle lane add y
     */
    public void leftLane(){
        // break;
    }

    /**
     * @return none
     * @param State:state
     * changing lanes to the right: if its already right by gettingcurrentstate then dont move the y; if the player is on
     * the left or the middle lane add y
     */
    public void rightLane(){
        // break;
    }


    /**
     * @return Lane
     * @param none
     * get the y, if its 0, the current state is right lane, if its a 1 its the middle lane, and if its the 2 its the left lane
     */
    public void getCurrentState(){
        // break;
    }

    /**
     * @return boolean
     * @param 
     */
    public void collisionDetection(Obstacle rb){
        /**
         * what do i need to check?
         *  check what the state of the player is
         *  check the type of rb
         *  check the x and y coordinate of the player
         *  check the x and y coordinate of the rb
         * 
         * if the players x and y is where rb x y is and if the state of the player is jumpting and rb is truck
         *  return false
         * 
         */
    }
    public boolean collisionDetection(RoadBlock rb){
        return false;
        
    }

    public void serialize() {

    }

    public void deserialize() {
        
    }
}
