/*
 * Copyright (c) 2017 Dragan Zuvic
 *
 * This file is part of jtsgen.
 *
 * jtsgen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jtsgen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jtsgen.  If not, see http://www.gnu.org/licenses/
 *
 */

package dz.jtsgen.processor.jtp.conv;

import dz.jtsgen.processor.jtp.info.TSProcessingInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.lang.model.element.TypeElement;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaTypeElementExtractingVisitorTest {

    private TypeElement typeElement;

    private JavaTypeElementExtractingVisitor testee;

    private TSProcessingInfo param;

    @BeforeEach
    void init() {
        this.typeElement = Mockito.mock(TypeElement.class);
        this.param = Mockito.mock(TSProcessingInfo.class);
        this.testee = new JavaTypeElementExtractingVisitor(this.typeElement,this.param, null) ;
    }


    @Test
    void visitType() {

        // currently not used
        assertNull(testee.visitType(this.typeElement,null));
    }

    @Test
    @DisplayName("typeElement and Converter must not be null for JavaTypeElementVisitor")
    void checkNullFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new JavaTypeElementExtractingVisitor(null,null,null));

        assertThrows(IllegalArgumentException.class,
                () -> new JavaTypeElementExtractingVisitor(this.typeElement,null,null));

    }

}