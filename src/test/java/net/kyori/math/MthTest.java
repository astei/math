/*
 * This file is part of math, licensed under the MIT License.
 *
 * Copyright (c) 2017-2018 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MthTest {
  @Test
  void testClamp_double() {
    assertEquals(10.0d, Mth.clamp(5.2d, 10.0d, 20.0d));
    assertEquals(15.2d, Mth.clamp(15.2d, 10.0d, 20.0d));
    assertEquals(20.0d, Mth.clamp(21.2d, 10.0d, 20.0d));
  }

  @Test
  void testClamp_float() {
    assertEquals(10.0f, Mth.clamp(5.2f, 10.0f, 20.0f));
    assertEquals(15.2f, Mth.clamp(15.2f, 10.0f, 20.0f));
    assertEquals(20.0f, Mth.clamp(21.2f, 10.0f, 20.0f));
  }

  @Test
  void testClamp_int() {
    assertEquals(10, Mth.clamp(5, 10, 20));
    assertEquals(15, Mth.clamp(15, 10, 20));
    assertEquals(20, Mth.clamp(21, 10, 20));
  }

  @Test
  void testClamp_long() {
    assertEquals(10L, Mth.clamp(5L, 10L, 20L));
    assertEquals(15L, Mth.clamp(15L, 10L, 20L));
    assertEquals(20L, Mth.clamp(21L, 10L, 20L));
  }
}
