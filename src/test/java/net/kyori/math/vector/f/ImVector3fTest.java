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
package net.kyori.math.vector.f;

import net.kyori.math.Mth;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static net.kyori.math.MathAssertions.assertImVectorEquals;
import static net.kyori.math.MathAssertions.assertThat;
import static net.kyori.math.MathAssertions.assertVectorEquals;
import static net.kyori.math.vector.f.ImVector3f.of;
import static net.kyori.math.vector.f.ImVector3f.zero;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImVector3fTest {
  @Test
  void testConstructor() {
    assertVectorEquals(1f, 2f, 3f, new ImVector3f(1f, 2f, 3f));
  }

  @Test
  void testOf() {
    assertSame(zero(), of(0f));
    assertSame(zero(), of(0f, 0f, 0f));
    assertVectorEquals(1f, 1f, 1f, of(1f));
  }

  @Test
  void testGetX() {
    assertEquals(0f, zero().x());
    assertEquals(1.5f, of(1.5f, 0f, 0f).x());
  }

  @Test
  void testSetX() {
    assertImVectorEquals(1.5f, 0f, 0f, zero(), v0 -> v0.x(1.5f));
  }

  @Test
  void testGetY() {
    assertEquals(0f, zero().y());
    assertEquals(1.5f, of(0f, 1.5f, 0f).y());
  }

  @Test
  void testSetY() {
    assertImVectorEquals(0f, 1.5f, 0f, zero(), v0 -> v0.y(1.5f));
  }

  @Test
  void testGetZ() {
    assertEquals(0f, zero().z());
    assertEquals(1.5f, of(0f, 0f, 1.5f).z());
  }

  @Test
  void testSetZ() {
    assertImVectorEquals(0f, 0f, 1.5f, zero(), v0 -> v0.z(1.5f));
  }

  @Test
  void testIsZero() {
    assertTrue(zero().isZero());
    assertFalse(of(0f, 0f, 1f).isZero());
  }

  @Test
  void testAdd() {
    assertImVectorEquals(1f, 2f, 3f, zero(), v0 -> v0.add(1f, 2f, 3f));
    assertImVectorEquals(1f, 2f, 3f, zero(), v0 -> v0.add(of(1f, 2f, 3f)));
    assertImVectorEquals(1f, 1f, 1f, zero(), v0 -> v0.add(1f));
  }

  @Test
  void testSub() {
    assertImVectorEquals(-1f, -2f, -3f, zero(), v0 -> v0.sub(1f, 2f, 3f));
    assertImVectorEquals(-1f, -2f, -3f, zero(), v0 -> v0.sub(of(1f, 2f, 3f)));
    assertImVectorEquals(-1f, -1f, -1f, zero(), v0 -> v0.sub(1f));
  }

  @Test
  void testMul() {
    assertImVectorEquals(1f, 2f, 3f, of(1f, 1f, 1f), v0 -> v0.mul(1f, 2f, 3f));
    assertImVectorEquals(1f, 2f, 3f, of(1f, 1f, 1f), v0 -> v0.mul(of(1f, 2f, 3f)));
    assertImVectorEquals(1f, 1f, 1f, of(1f, 1f, 1f), v0 -> v0.mul(1f));
  }

  @Test
  void testDiv() {
    assertImVectorEquals(1f, 1.5f, 2f, of(2f, 3f, 4f), v0 -> v0.div(2f, 2f, 2f));
    assertImVectorEquals(1f, 1.5f, 2f, of(2f, 3f, 4f), v0 -> v0.div(of(2f, 2f, 2f)));
    assertImVectorEquals(1f, 1.5f, 2f, of(2f, 3f, 4f), v0 -> v0.div(2f));
  }

  @Test
  void testAbs() {
    assertImVectorEquals(2.3f, 3.4f, 4.5f, of(-2.3f, -3.4f, -4.5f), Vector3f::abs);
    assertImVectorEquals(2.3f, 3.4f, 4.5f, of(2.3f, 3.4f, 4.5f), Vector3f::abs);
  }

  @Test
  void testCeil() {
    assertImVectorEquals(2f, 3f, 4f, of(1.2f, 2.3f, 3.4f), Vector3f::ceil);
  }

  @Test
  void testFloor() {
    assertImVectorEquals(1f, 2f, 3f, of(1.2f, 2.3f, 3.4f), Vector3f::floor);
  }

  @Test
  void testNegate() {
    assertImVectorEquals(-1.2f, -2.3f, -3.4f, of(1.2f, 2.3f, 3.4f), Vector3f::negate);
  }

  @Test
  void testNormalize() {
    assertImVectorEquals(1f, 0f, 0f, of(2f, 0f, 0f), Vector3f::normalize);
    assertImVectorEquals(0f, 1f, 0f, of(0f, 2f, 0f), Vector3f::normalize);
    assertImVectorEquals(0f, 0f, 1f, of(0f, 0f, 2f), Vector3f::normalize);
  }

  @Test
  void testPow() {
    assertImVectorEquals(4f, 16f, 36f, of(2f, 4f, 6f), v0 -> v0.pow(2f));
  }

  @Test
  void testRound() {
    assertImVectorEquals(2f, 5f, 6f, of(2.3f, 4.6f, 6.4f), Vector3f::round);
  }

  @Test
  void testLengthSquared() {
    assertEquals(50f, of(3f, 4f, 5f).lengthSquared());
  }

  @Test
  void testLength() {
    assertEquals(5f * Mth.sqrt(2f), of(3f, 4f, 5f).length());
  }

  @Test
  void testMinimum() {
    assertImVectorEquals(2.1f, 4.3f, 8.1f, of(2.1f, 5.1f, 8.1f), v0 -> v0.minimum(of(3.2f, 4.3f, 9.4f)));
  }

  @Test
  void testMaximum() {
    assertImVectorEquals(3.2f, 5.1f, 9.4f, of(2.1f, 5.1f, 8.1f), v0 -> v0.maximum(of(3.2f, 4.3f, 9.4f)));
  }

  @Test
  void testArray() {
    assertThat(zero().array()).usingExactEquality().containsExactly(0, 0, 0).inOrder();
    assertThat(of(1, 2, 3).array()).usingExactEquality().containsExactly(1, 2, 3).inOrder();
  }

  @Test
  void testStream() {
    assertThat(zero().stream()).containsExactly(0d, 0d, 0d).inOrder();
    assertThat(of(1f, 2f, 3f).stream()).containsExactly(1d, 2d, 3d).inOrder();
  }

  @Test
  void testMap() {
    assertImVectorEquals(1f, 1f, 1f, zero(), v0 -> v0.map(x -> x + 1f, y -> y + 1f, z -> z + 1f));
  }

  @Test
  void testAllMatch() {
    assertTrue(zero().allMatch(value -> value == 0f));
    final ImVector3f v0 = of(1f, 1f, 1f);
    assertTrue(v0.allMatch(value -> value == 1f));
    final ImVector3f v1 = of(1f, 2f, 3f);
    assertFalse(v1.allMatch(value -> value == 1f));
    assertFalse(v1.allMatch(value -> value == 2f));
    assertFalse(v1.allMatch(value -> value == 3f));
  }

  @Test
  void testAnyMatch() {
    assertTrue(zero().anyMatch(value -> value == 0f));
    final ImVector3f v0 = of(1f, 1f, 1f);
    assertTrue(v0.anyMatch(value -> value == 1f));
    final ImVector3f v1 = of(1f, 2f, 3f);
    assertTrue(v1.anyMatch(value -> value == 1f));
    assertTrue(v1.anyMatch(value -> value == 2f));
    assertTrue(v1.anyMatch(value -> value == 3f));
  }

  @Test
  void testAllFinite() {
    assertTrue(zero().allFinite());
    assertFalse(of(Float.NaN).allFinite());
    assertFalse(of(0f, Float.NaN, 0f).allFinite());
    assertFalse(of(Float.NEGATIVE_INFINITY).allFinite());
  }

  @Test
  void testAnyFinite() {
    assertTrue(zero().anyFinite());
    assertFalse(of(Float.NaN).anyFinite());
    assertTrue(of(0f, Float.NaN, 0f).anyFinite());
    assertFalse(of(Float.NEGATIVE_INFINITY).anyFinite());
  }

  @Test
  void testAllInfinite() {
    assertFalse(zero().allInfinite());
    assertTrue(of(Float.NEGATIVE_INFINITY).allInfinite());
    assertTrue(of(Float.POSITIVE_INFINITY).allInfinite());
  }

  @Test
  void testAnyInfinite() {
    assertFalse(zero().anyInfinite());
    assertFalse(of(1f).anyInfinite());
    assertTrue(of(0f, Float.NEGATIVE_INFINITY, 0f).anyInfinite());
  }

  @Test
  void testAllNaN() {
    assertFalse(zero().allNaN());
    assertTrue(of(Float.NaN).allNaN());
    assertFalse(of(0f, Float.NaN, 0f).allNaN());
  }

  @Test
  void testAnyNaN() {
    assertFalse(zero().anyNaN());
    assertTrue(of(Float.NaN).anyNaN());
    assertTrue(of(0f, Float.NaN, 0f).anyNaN());
  }

  @Test
  void testEquals() {
    assertEquals(zero(), zero());
    assertEquals(zero(), of(0f, 0f, 0f));
    assertNotEquals(zero(), of(0f, 0f, 1f));
  }

  @Test
  void testHashCode() {
    assertEquals(zero().hashCode(), zero().hashCode());
    assertEquals(zero().hashCode(), of(0f, 0f, 0f).hashCode());
    assertNotEquals(zero().hashCode(), of(0f, 0f, 1f).hashCode());
  }

  @Test
  void testDot() {
    assertEquals(0f, of(1f, 1f, 1f).dot(zero()));
    // dotting a vector with itself is its length squared
    assertEquals(3f, of(1f, 1f, 1f).dot(of(1f, 1f, 1f)));
    assertEquals(3f, of(3f, 2f, 4f).dot(of(1f, -2f, 1f)));
  }
}
