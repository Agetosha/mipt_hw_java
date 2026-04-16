package edu.phystech.hw2.analyzer;

import java.util.Collection;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract Collection<String> getKeywords();
    
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}