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
import net.kyori.math.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public interface Vectorf extends Vector {
  @NonNull Vectorf add(final float n);

  @NonNull Vectorf sub(final float n);

  @NonNull Vectorf mul(final float n);

  @NonNull Vectorf div(final float n);

  @Override
  @NonNull Vectorf abs();

  @NonNull Vectorf ceil();

  @NonNull Vectorf floor();

  @Override
  @NonNull Vectorf negate();

  @NonNull Vectorf normalize();

  @NonNull Vectorf pow(final float power);

  @NonNull Vectorf round();

  float lengthSquared();

  default float length() {
    return Mth.sqrt(this.lengthSquared());
  }

  float[] array();

  // no float variant
  @NonNull DoubleStream stream();

  // no float variant
  @NonNull Vectorf map(final @NonNull DoubleUnaryOperator operator);

  // no float variant
  boolean allMatch(final @NonNull DoublePredicate predicate);

  // no float variant
  boolean anyMatch(final @NonNull DoublePredicate predicate);

  default boolean allFinite() {
    return this.allMatch(value -> Float.isFinite((float) value));
  }

  default boolean anyFinite() {
    return this.anyMatch(value -> Float.isFinite((float) value));
  }

  default boolean allInfinite() {
    return this.allMatch(value -> Float.isInfinite((float) value));
  }

  default boolean anyInfinite() {
    return this.anyMatch(value -> Float.isInfinite((float) value));
  }

  default boolean allNaN() {
    return this.allMatch(value -> Float.isNaN((float) value));
  }

  default boolean anyNaN() {
    return this.anyMatch(value -> Float.isNaN((float) value));
  }

  @NonNull Vectorf copy();
}
