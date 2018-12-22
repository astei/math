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
package net.kyori.math.vector.d;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static net.kyori.math.MathAssertions.assertImVectorEquals;
import static net.kyori.math.MathAssertions.assertThat;
import static net.kyori.math.MathAssertions.assertVectorEquals;
import static net.kyori.math.vector.d.ImVector3d.of;
import static net.kyori.math.vector.d.ImVector3d.zero;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImVector3dTest {
  @Test
  void testConstructor() {
    assertVectorEquals(1d, 2d, 3d, new ImVector3d(1d, 2d, 3d));
  }

  @Test
  void testOf() {
    assertSame(zero(), of(0d));
    assertSame(zero(), of(0d, 0d, 0d));
    assertVectorEquals(1d, 1d, 1d, of(1d));
  }

  @Test
  void testGetX() {
    assertEquals(0d, zero().x());
    assertEquals(1.5d, of(1.5d, 0d, 0d).x());
  }

  @Test
  void testSetX() {
    assertImVectorEquals(1.5d, 0d, 0d, zero(), v0 -> v0.x(1.5d));
  }

  @Test
  void testGetY() {
    assertEquals(0d, zero().y());
    assertEquals(1.5d, of(0d, 1.5d, 0d).y());
  }

  @Test
  void testSetY() {
    assertImVectorEquals(0d, 1.5d, 0d, zero(), v0 -> v0.y(1.5d));
  }

  @Test
  void testGetZ() {
    assertEquals(0d, zero().z());
    assertEquals(1.5d, of(0d, 0d, 1.5d).z());
  }

  @Test
  void testSetZ() {
    assertImVectorEquals(0d, 0d, 1.5d, zero(), v0 -> v0.z(1.5d));
  }

  @Test
  void testIsZero() {
    assertTrue(zero().isZero());
    assertFalse(of(0d, 0d, 1d).isZero());
  }

  @Test
  void testAdd() {
    assertImVectorEquals(1d, 2d, 3d, zero(), v0 -> v0.add(1d, 2d, 3d));
    assertImVectorEquals(1d, 2d, 3d, zero(), v0 -> v0.add(of(1d, 2d, 3d)));
    assertImVectorEquals(1d, 1d, 1d, zero(), v0 -> v0.add(1d));
  }

  @Test
  void testSub() {
    assertImVectorEquals(-1d, -2d, -3d, zero(), v0 -> v0.sub(1d, 2d, 3d));
    assertImVectorEquals(-1d, -2d, -3d, zero(), v0 -> v0.sub(of(1d, 2d, 3d)));
    assertImVectorEquals(-1d, -1d, -1d, zero(), v0 -> v0.sub(1d));
  }

  @Test
  void testMul() {
    assertImVectorEquals(1d, 2d, 3d, of(1d, 1d, 1d), v0 -> v0.mul(1d, 2d, 3d));
    assertImVectorEquals(1d, 2d, 3d, of(1d, 1d, 1d), v0 -> v0.mul(of(1d, 2d, 3d)));
    assertImVectorEquals(1d, 1d, 1d, of(1d, 1d, 1d), v0 -> v0.mul(1d));
  }

  @Test
  void testDiv() {
    assertImVectorEquals(1d, 1.5d, 2d, of(2d, 3d, 4d), v0 -> v0.div(2d, 2d, 2d));
    assertImVectorEquals(1d, 1.5d, 2d, of(2d, 3d, 4d), v0 -> v0.div(of(2d, 2d, 2d)));
    assertImVectorEquals(1d, 1.5d, 2d, of(2d, 3d, 4d), v0 -> v0.div(2d));
  }

  @Test
  void testAbs() {
    assertImVectorEquals(2.3d, 3.4d, 4.5d, of(-2.3d, -3.4d, -4.5d), Vector3d::abs);
    assertImVectorEquals(2.3d, 3.4d, 4.5d, of(2.3d, 3.4d, 4.5d), Vector3d::abs);
  }

  @Test
  void testCeil() {
    assertImVectorEquals(2d, 3d, 4d, of(1.2d, 2.3d, 3.4d), Vector3d::ceil);
  }

  @Test
  void testFloor() {
    assertImVectorEquals(1d, 2d, 3d, of(1.2d, 2.3d, 3.4d), Vector3d::floor);
  }

  @Test
  void testNegate() {
    assertImVectorEquals(-1.2d, -2.3d, -3.4d, of(1.2d, 2.3d, 3.4d), Vector3d::negate);
  }

  @Test
  void testNormalize() {
    assertImVectorEquals(1d, 0d, 0d, of(2d, 0d, 0d), Vector3d::normalize);
    assertImVectorEquals(0d, 1d, 0d, of(0d, 2d, 0d), Vector3d::normalize);
    assertImVectorEquals(0d, 0d, 1d, of(0d, 0d, 2d), Vector3d::normalize);
  }

  @Test
  void testPow() {
    assertImVectorEquals(4d, 16d, 36d, of(2d, 4d, 6d), v0 -> v0.pow(2d));
  }

  @Test
  void testRound() {
    assertImVectorEquals(2d, 5d, 6d, of(2.3d, 4.6d, 6.4d), Vector3d::round);
  }

  @Test
  void testLengthSquared() {
    assertEquals(50d, of(3d, 4d, 5d).lengthSquared());
  }

  @Test
  void testLength() {
    assertEquals(5d * Math.sqrt(2d), of(3d, 4d, 5d).length());
  }

  @Test
  void testMinimum() {
    assertImVectorEquals(2.1d, 4.3d, 8.1d, of(2.1d, 5.1d, 8.1d), v0 -> v0.minimum(of(3.2d, 4.3d, 9.4d)));
  }

  @Test
  void testMaximum() {
    assertImVectorEquals(3.2d, 5.1d, 9.4d, of(2.1d, 5.1d, 8.1d), v0 -> v0.maximum(of(3.2d, 4.3d, 9.4d)));
  }

  @Test
  void testArray() {
    assertThat(zero().array()).usingExactEquality().containsExactly(0d, 0d, 0d).inOrder();
    assertThat(of(1d, 2d, 3d).array()).usingExactEquality().containsExactly(1d, 2d, 3d).inOrder();
  }

  @Test
  void testStream() {
    assertThat(zero().stream()).containsExactly(0d, 0d, 0d).inOrder();
    assertThat(of(1d, 2d, 3d).stream()).containsExactly(1d, 2d, 3d).inOrder();
  }

  @Test
  void testMap() {
    assertImVectorEquals(1d, 1d, 1d, zero(), v0 -> v0.map(x -> x + 1d, y -> y + 1d, z -> z + 1d));
  }

  @Test
  void testAllMatch() {
    assertTrue(zero().allMatch(value -> value == 0d));
    final ImVector3d v0 = of(1d, 1d, 1d);
    assertTrue(v0.allMatch(value -> value == 1d));
    final ImVector3d v1 = of(1d, 2d, 3d);
    assertFalse(v1.allMatch(value -> value == 1d));
    assertFalse(v1.allMatch(value -> value == 2d));
    assertFalse(v1.allMatch(value -> value == 3d));
  }

  @Test
  void testAnyMatch() {
    assertTrue(zero().anyMatch(value -> value == 0d));
    final ImVector3d v0 = of(1d, 1d, 1d);
    assertTrue(v0.anyMatch(value -> value == 1d));
    final ImVector3d v1 = of(1d, 2d, 3d);
    assertTrue(v1.anyMatch(value -> value == 1d));
    assertTrue(v1.anyMatch(value -> value == 2d));
    assertTrue(v1.anyMatch(value -> value == 3d));
  }

  @Test
  void testAllFinite() {
    assertTrue(zero().allFinite());
    assertFalse(of(Double.NaN).allFinite());
    assertFalse(of(0d, Double.NaN, 0d).allFinite());
    assertFalse(of(Double.NEGATIVE_INFINITY).allFinite());
  }

  @Test
  void testAnyFinite() {
    assertTrue(zero().anyFinite());
    assertFalse(of(Double.NaN).anyFinite());
    assertTrue(of(0d, Double.NaN, 0d).anyFinite());
    assertFalse(of(Double.NEGATIVE_INFINITY).anyFinite());
  }

  @Test
  void testAllInfinite() {
    assertFalse(zero().allInfinite());
    assertTrue(of(Double.NEGATIVE_INFINITY).allInfinite());
    assertTrue(of(Double.POSITIVE_INFINITY).allInfinite());
  }

  @Test
  void testAnyInfinite() {
    assertFalse(zero().anyInfinite());
    assertFalse(of(1d).anyInfinite());
    assertTrue(of(0d, Double.NEGATIVE_INFINITY, 0d).anyInfinite());
  }

  @Test
  void testAllNaN() {
    assertFalse(zero().allNaN());
    assertTrue(of(Double.NaN).allNaN());
    assertFalse(of(0d, Double.NaN, 0d).allNaN());
  }

  @Test
  void testAnyNaN() {
    assertFalse(zero().anyNaN());
    assertTrue(of(Double.NaN).anyNaN());
    assertTrue(of(0d, Double.NaN, 0d).anyNaN());
  }

  @Test
  void testEquals() {
    assertEquals(zero(), zero());
    assertEquals(zero(), of(0d, 0d, 0d));
    assertNotEquals(zero(), of(0d, 0d, 1d));
  }

  @Test
  void testHashCode() {
    assertEquals(zero().hashCode(), zero().hashCode());
    assertEquals(zero().hashCode(), of(0d, 0d, 0d).hashCode());
    assertNotEquals(zero().hashCode(), of(0d, 0d, 1d).hashCode());
  }

  @Test
  void testDot() {
    assertEquals(0d, of(1d, 1d, 1d).dot(zero()));
    // dotting a vector with itself is its length squared
    assertEquals(3d, of(1d, 1d, 1d).dot(of(1d, 1d, 1d)));
    assertEquals(3d, of(3d, 2d, 4d).dot(of(1d, -2d, 1d)));
  }
}
