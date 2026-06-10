package edu.phystech.hw2.contact;

public record Contact(String username, String email) implements Comparable<Contact> {
    public static final String UNKNOWN_EMAIL = "unknown";

    public Contact {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidContactFieldException("username");
        }
        if (email == null || (!email.equals(UNKNOWN_EMAIL) && !email.endsWith("@gmail.com"))) {
            throw new InvalidContactFieldException("email");
        }
    }

    public Contact(String username) {
        this(username, UNKNOWN_EMAIL);
    }

    @Override
    public int compareTo(Contact other) {
        return Integer.compare(this.username.length(), other.username().length());
    }
}