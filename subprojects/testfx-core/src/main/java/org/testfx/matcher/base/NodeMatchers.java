/*
 * Copyright 2013-2014 SmartBear Software
 *
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by the European
 * Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work
 * except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the Licence for the specific language governing permissions
 * and limitations under the Licence.
 */
package org.testfx.matcher.base;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextInputControl;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.testfx.api.annotation.Unstable;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

import static org.testfx.matcher.base.BaseMatchers.baseMatcher;

@Unstable(reason = "needs more tests")
public class NodeMatchers {

    //---------------------------------------------------------------------------------------------
    // STATIC FACTORY METHODS.
    //---------------------------------------------------------------------------------------------

    @Factory
    public static Matcher<Node> isNull() {
        return baseMatcher("Node is null", node -> isNull(node));
    }

    @Factory
    public static Matcher<Node> isNotNull() {
        return baseMatcher("Node is not null", node -> !isNull(node));
    }

    @Factory
    public static Matcher<Node> isVisible() {
        return baseMatcher("Node is visible", node -> isVisible(node));
    }

    @Factory
    public static Matcher<Node> isInvisible() {
        return baseMatcher("Node is invisible", node -> !isVisible(node));
    }

    @Factory
    public static Matcher<Node> isEnabled() {
        return baseMatcher("Node is enabled", node -> isEnabled(node));
    }

    @Factory
    public static Matcher<Node> isDisabled() {
        return baseMatcher("Node is disabled", node -> !isEnabled(node));
    }

    @Factory
    public static Matcher<Node> hasText(String text) {
        String descriptionText = "Node has text '" + text + "'";
        return baseMatcher(descriptionText, node -> hasText(node, text));
    }

    //---------------------------------------------------------------------------------------------
    // STATIC METHODS.
    //---------------------------------------------------------------------------------------------

    public static boolean isNull(Node node) {
        return node == null;
    }

    public static boolean isVisible(Node node) {
        return node.isVisible();
    }

    public static boolean isEnabled(Node node) {
        return !node.isDisabled();
    }

    public static boolean hasText(Node node,
                                  String text) {
        if (node instanceof Labeled) {
            return LabeledMatchers.hasText((Labeled) node, text);
        }
        else if (node instanceof TextInputControl) {
            return TextInputControlMatchers.hasText((TextInputControl) node, text);
        }
        return false;
    }

}