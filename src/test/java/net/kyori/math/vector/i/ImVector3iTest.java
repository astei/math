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
package net.kyori.math.vector.i;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static net.kyori.math.MathAssertions.assertImVectorEquals;
import static net.kyori.math.MathAssertions.assertThat;
import static net.kyori.math.MathAssertions.assertVectorEquals;
import static net.kyori.math.vector.i.ImVector3i.of;
import static net.kyori.math.vector.i.ImVector3i.zero;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImVector3iTest {
  @Test
  void testConstructor() {
    assertVectorEquals(1, 2, 3, new ImVector3i(1, 2, 3));
  }

  @Test
  void testOf() {
    assertSame(zero(), of(0));
    assertSame(zero(), of(0, 0, 0));
    assertVectorEquals(1, 1, 1, of(1));
  }

  @Test
  void testGetX() {
    assertEquals(0, zero().x());
    assertEquals(1, of(1, 0, 0).x());
  }

  @Test
  void testSetX() {
    assertImVectorEquals(1, 0, 0, zero(), v0 -> v0.x(1));
  }

  @Test
  void testGetY() {
    assertEquals(0, zero().y());
    assertEquals(1, of(0, 1, 0).y());
  }

  @Test
  void testSetY() {
    assertImVectorEquals(0, 1, 0, zero(), v0 -> v0.y(1));
  }

  @Test
  void testGetZ() {
    assertEquals(0, zero().z());
    assertEquals(1, of(0, 0, 1).z());
  }

  @Test
  void testSetZ() {
    assertImVectorEquals(0, 0, 1, zero(), v0 -> v0.z(1));
  }

  @Test
  void testIsZero() {
    assertTrue(zero().isZero());
    assertFalse(of(0, 0, 1).isZero());
  }

  @Test
  void testAdd() {
    assertImVectorEquals(1, 2, 3, zero(), v0 -> v0.add(1, 2, 3));
    assertImVectorEquals(1, 2, 3, zero(), v0 -> v0.add(of(1, 2, 3)));
    assertImVectorEquals(1, 1, 1, zero(), v0 -> v0.add(1));
  }

  @Test
  void testSub() {
    assertImVectorEquals(-1, -2, -3, zero(), v0 -> v0.sub(1, 2, 3));
    assertImVectorEquals(-1, -2, -3, zero(), v0 -> v0.sub(of(1, 2, 3)));
    assertImVectorEquals(-1, -1, -1, zero(), v0 -> v0.sub(1));
  }

  @Test
  void testMul() {
    assertImVectorEquals(1, 2, 3, of(1, 1, 1), v0 -> v0.mul(1, 2, 3));
    assertImVectorEquals(1, 2, 3, of(1, 1, 1), v0 -> v0.mul(of(1, 2, 3)));
    assertImVectorEquals(1, 1, 1, of(1, 1, 1), v0 -> v0.mul(1));
  }

  @Test
  void testDiv() {
    assertImVectorEquals(1, 1, 2, of(2, 3, 4), v0 -> v0.div(2, 2, 2));
    assertImVectorEquals(1, 1, 2, of(2, 3, 4), v0 -> v0.div(of(2, 2, 2)));
    assertImVectorEquals(1, 1, 2, of(2, 3, 4), v0 -> v0.div(2));
  }

  @Test
  void testAbs() {
    assertImVectorEquals(2, 3, 4, of(-2, -3, -4), Vector3i::abs);
    assertImVectorEquals(2, 3, 4, of(2, 3, 4), Vector3i::abs);
  }

  @Test
  void testNegate() {
    assertImVectorEquals(-1, -2, -3, of(1, 2, 3), Vector3i::negate);
  }

  @Test
  void testPow() {
    assertImVectorEquals(4, 16, 36, of(2, 4, 6), v0 -> v0.pow(2));
  }

  @Test
  void testLengthSquared() {
    assertEquals(50, of(3, 4, 5).lengthSquared());
  }

  @Test
  void testLength() {
    assertEquals(5d * Math.sqrt(2), of(3, 4, 5).length());
  }

  @Test
  void testMinimum() {
    assertImVectorEquals(2, 4, 8, of(2, 5, 8), v0 -> v0.minimum(of(3, 4, 9)));
  }

  @Test
  void testMaximum() {
    assertImVectorEquals(3, 5, 9, of(2, 5, 8), v0 -> v0.maximum(of(3, 4, 9)));
  }

  @Test
  void testArray() {
    assertThat(zero().array()).asList().containsExactly(0, 0, 0).inOrder();
    assertThat(of(1, 2, 3).array()).asList().containsExactly(1, 2, 3).inOrder();
  }

  @Test
  void testStream() {
    assertThat(zero().stream()).containsExactly(0, 0, 0).inOrder();
    assertThat(of(1, 2, 3).stream()).containsExactly(1, 2, 3).inOrder();
  }

  @Test
  void testMap() {
    assertImVectorEquals(1, 1, 1, zero(), v0 -> v0.map(x -> x + 1, y -> y + 1, z -> z + 1));
  }

  @Test
  void testAllMatch() {
    assertTrue(zero().allMatch(value -> value == 0));
    final ImVector3i v0 = of(1, 1, 1);
    assertTrue(v0.allMatch(value -> value == 1));
    final ImVector3i v1 = of(1, 2, 3);
    assertFalse(v1.allMatch(value -> value == 1));
    assertFalse(v1.allMatch(value -> value == 2));
    assertFalse(v1.allMatch(value -> value == 3));
  }

  @Test
  void testAnyMatch() {
    assertTrue(zero().anyMatch(value -> value == 0));
    final ImVector3i v0 = of(1, 1, 1);
    assertTrue(v0.anyMatch(value -> value == 1));
    final ImVector3i v1 = of(1, 2, 3);
    assertTrue(v1.anyMatch(value -> value == 1));
    assertTrue(v1.anyMatch(value -> value == 2));
    assertTrue(v1.anyMatch(value -> value == 3));
  }

  @Test
  void testEquals() {
    assertEquals(zero(), zero());
    assertEquals(zero(), of(0, 0, 0));
    assertNotEquals(zero(), of(0, 0, 1));
  }

  @Test
  void testHashCode() {
    assertEquals(zero().hashCode(), zero().hashCode());
    assertEquals(zero().hashCode(), of(0, 0, 0).hashCode());
    assertNotEquals(zero().hashCode(), of(0, 0, 1).hashCode());
  }
}
