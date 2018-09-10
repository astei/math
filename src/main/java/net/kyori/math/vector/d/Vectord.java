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

import net.kyori.math.vector.Vector;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public interface Vectord extends Vector {
  @NonNull Vectord add(final double n);

  @NonNull Vectord sub(final double n);

  @NonNull Vectord mul(final double n);

  @NonNull Vectord div(final double n);

  @Override
  @NonNull Vectord abs();

  @NonNull Vectord ceil();

  @NonNull Vectord floor();

  @Override
  @NonNull Vectord negate();

  @NonNull Vectord normalize();

  @NonNull Vectord pow(final double power);

  @NonNull Vectord round();

  double lengthSquared();

  default double length() {
    return Math.sqrt(this.lengthSquared());
  }

  double[] array();

  @NonNull DoubleStream stream();

  @NonNull Vectord map(final @NonNull DoubleUnaryOperator operator);

  boolean allMatch(final @NonNull DoublePredicate predicate);

  boolean anyMatch(final @NonNull DoublePredicate predicate);

  default boolean allFinite() {
    return this.allMatch(Double::isFinite);
  }

  default boolean anyFinite() {
    return this.anyMatch(Double::isFinite);
  }

  default boolean allInfinite() {
    return this.allMatch(Double::isInfinite);
  }

  default boolean anyInfinite() {
    return this.anyMatch(Double::isInfinite);
  }

  default boolean allNaN() {
    return this.allMatch(Double::isNaN);
  }

  default boolean anyNaN() {
    return this.anyMatch(Double::isNaN);
  }

  @NonNull Vectord copy();
}
