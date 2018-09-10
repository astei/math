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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public interface Vector3f extends Vectorf {
  float x();

  @NonNull Vector3f x(final float x);

  float y();

  @NonNull Vector3f y(final float y);

  float z();

  @NonNull Vector3f z(final float z);

  @Override
  default boolean isZero() {
    return this.x() == 0d && this.y() == 0d && this.z() == 0d;
  }

  @NonNull Vector3f add(final float x, final float y, final float z);

  default @NonNull Vector3f add(final Vector3f that) {
    return this.add(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3f add(final float n) {
    return this.add(n, n, n);
  }

  @NonNull Vector3f sub(final float x, final float y, final float z);

  default @NonNull Vector3f sub(final Vector3f that) {
    return this.sub(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3f sub(final float n) {
    return this.sub(n, n, n);
  }

  @NonNull Vector3f mul(final float x, final float y, final float z);

  default @NonNull Vector3f mul(final Vector3f that) {
    return this.mul(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3f mul(final float n) {
    return this.mul(n, n, n);
  }

  @NonNull Vector3f div(final float x, final float y, final float z);

  default @NonNull Vector3f div(final Vector3f that) {
    return this.div(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3f div(final float n) {
    return this.div(n, n, n);
  }

  @Override
  @NonNull Vector3f abs();

  @Override
  @NonNull Vector3f ceil();

  @Override
  @NonNull Vector3f floor();

  @Override
  @NonNull Vector3f negate();

  @Override
  @NonNull Vector3f normalize();

  @Override
  @NonNull Vector3f pow(final float power);

  @Override
  @NonNull Vector3f round();

  @Override
  default float lengthSquared() {
    final float x = this.x();
    final float y = this.y();
    final float z = this.z();
    return x * x + y * y + z * z;
  }

  default @NonNull Vector3f minimum(final @NonNull Vector3f that) {
    return this.map(that, Math::min);
  }

  default @NonNull Vector3f maximum(final @NonNull Vector3f that) {
    return this.map(that, Math::max);
  }

  @Override
  default @NonNull DoubleStream stream() {
    return DoubleStream.of(this.x(), this.y(), this.z());
  }

  @Override
  @NonNull Vector3f map(final @NonNull DoubleUnaryOperator operator);

  @NonNull Vector3f map(final @NonNull Vector3f that, final @NonNull DoubleBinaryOperator operator);

  @NonNull Vector3f map(final @NonNull DoubleUnaryOperator x, final @NonNull DoubleUnaryOperator y, final @NonNull DoubleUnaryOperator z);

  @Override
  default boolean allMatch(final @NonNull DoublePredicate predicate) {
    return predicate.test(this.x()) && predicate.test(this.y()) && predicate.test(this.z());
  }

  @Override
  default boolean anyMatch(final @NonNull DoublePredicate predicate) {
    return predicate.test(this.x()) || predicate.test(this.y()) || predicate.test(this.z());
  }

  @Override @NonNull Vector3f copy();

  default boolean equals(final @Nullable Vector3f that) {
    return that != null
      && this.x() == that.x()
      && this.y() == that.y()
      && this.z() == that.z();
  }
}
