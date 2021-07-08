package com.mdt.ocp.chapter1.Codingequal;

public class Card {
    private String rank;
    private String suit;

    public Card(String r, String s) {
        if (r == null || s == null)
            throw new IllegalArgumentException();
        this.rank = r;
        this.suit = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card otherCard = (Card) obj;
        return rank.equals(otherCard.rank) && suit.equals(otherCard.suit);
    }

    /**
     * They go in the same pile (hash code) if they have the same rank.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return rank.hashCode();
    }

    public static void main(String[] args) {
        Card card = new Card("5", "Heart");
        System.out.println(card.hashCode());
    }

}
