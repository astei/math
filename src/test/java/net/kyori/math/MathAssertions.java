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

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import com.google.common.truth.IterableSubject;
import com.google.common.truth.Truth;
import net.kyori.math.vector.d.Vector3d;
import net.kyori.math.vector.f.Vector3f;
import net.kyori.math.vector.i.Vector3i;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAssertions {
  private static final String X_NAME = "x";
  private static final String Y_NAME = "y";
  private static final String Z_NAME = "z";

  public static void assertVectorEquals(final double ex, final double ey, final double ez, final @NonNull Vector3d actual) {
    assertEquals(ex, actual.x(), X_NAME);
    assertEquals(ey, actual.y(), Y_NAME);
    assertEquals(ez, actual.z(), Z_NAME);
  }

  public static void assertImVectorEquals(final double ex, final double ey, final double ez, final @NonNull Vector3d original, final @NonNull Function<Vector3d, Vector3d> function) {
    final double ox = original.x();
    final double oy = original.y();
    final double oz = original.z();
    final Vector3d actual = function.apply(original);
    assertVectorEquals(ex, ey, ez, actual);
    assertVectorEquals(ox, oy, oz, original);
  }

  public static void assertVectorEquals(final float ex, final float ey, final float ez, final @NonNull Vector3f actual) {
    assertEquals(ex, actual.x(), X_NAME);
    assertEquals(ey, actual.y(), Y_NAME);
    assertEquals(ez, actual.z(), Z_NAME);
  }

  public static void assertImVectorEquals(final float ex, final float ey, final float ez, final @NonNull Vector3f original, final @NonNull Function<Vector3f, Vector3f> function) {
    final float ox = original.x();
    final float oy = original.y();
    final float oz = original.z();
    final Vector3f actual = function.apply(original);
    assertVectorEquals(ex, ey, ez, actual);
    assertVectorEquals(ox, oy, oz, original);
  }

  public static void assertVectorEquals(final int ex, final int ey, final int ez, final @NonNull Vector3i actual) {
    assertEquals(ex, actual.x(), X_NAME);
    assertEquals(ey, actual.y(), Y_NAME);
    assertEquals(ez, actual.z(), Z_NAME);
  }

  public static void assertImVectorEquals(final int ex, final int ey, final int ez, final @NonNull Vector3i original, final @NonNull Function<Vector3i, Vector3i> function) {
    final int ox = original.x();
    final int oy = original.y();
    final int oz = original.z();
    final Vector3i actual = function.apply(original);
    assertVectorEquals(ex, ey, ez, actual);
    assertVectorEquals(ox, oy, oz, original);
  }

  public static @NonNull IterableSubject assertThat(final @NonNull DoubleStream stream) {
    return Truth.assertThat(Doubles.asList(stream.toArray()));
  }

  public static @NonNull IterableSubject assertThat(final @NonNull IntStream stream) {
    return Truth.assertThat(Ints.asList(stream.toArray()));
  }
}
