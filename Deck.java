public class Deck {
    
    public Card drawCard() {
        //Fill in the contents of this method 
        //two random int
        int value = (int)((Math.random()*13) + 1);
        int Suit = (int)((Math.random()*4) + 1);

        String suit = null; 

        switch(Suit){
            case 1:
                suit = "Spades";
                break; 
            case 2: 
                suit = "Clubs"; 
                break; 
            case 3: 
                suit = "Hearts";
                break; 
            case 4:  
                suit = "Diamonds";
                break; 
        }

        return new Card(value, suit);
    }
}
