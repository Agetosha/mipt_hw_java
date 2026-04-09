package edu.phystech.hw2.analyzer;

import java.util.Collection;

public class SpamAnalyzer extends KeywordAnalyzer {
    private final Collection<String> keywords;

    public SpamAnalyzer(Collection<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    protected Collection<String> getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}