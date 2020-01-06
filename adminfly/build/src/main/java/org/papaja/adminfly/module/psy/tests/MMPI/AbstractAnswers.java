package org.papaja.adminfly.module.psy.tests.MMPI;

abstract public class AbstractAnswers implements Answers {

    @Override
    public Scale[] getScales(int question, Answer answer) {
        return getMap()[question - 1][answer.getValue()];
    }

    @Override
    public boolean hasScales(int question, Answer answer) {
        return getScales(question, answer).length > 0;
    }

}
