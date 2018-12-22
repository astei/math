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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public interface Vector3d extends Vectord {
  double x();

  @NonNull Vector3d x(final double x);

  double y();

  @NonNull Vector3d y(final double y);

  double z();

  @NonNull Vector3d z(final double z);

  @Override
  default boolean isZero() {
    return this.x() == 0d && this.y() == 0d && this.z() == 0d;
  }

  @NonNull Vector3d add(final double x, final double y, final double z);

  default @NonNull Vector3d add(final Vector3d that) {
    return this.add(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3d add(final double n) {
    return this.add(n, n, n);
  }

  @NonNull Vector3d sub(final double x, final double y, final double z);

  default @NonNull Vector3d sub(final Vector3d that) {
    return this.sub(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3d sub(final double n) {
    return this.sub(n, n, n);
  }

  @NonNull Vector3d mul(final double x, final double y, final double z);

  default @NonNull Vector3d mul(final Vector3d that) {
    return this.mul(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3d mul(final double n) {
    return this.mul(n, n, n);
  }

  @NonNull Vector3d div(final double x, final double y, final double z);

  default @NonNull Vector3d div(final Vector3d that) {
    return this.div(that.x(), that.y(), that.z());
  }

  @Override
  default @NonNull Vector3d div(final double n) {
    return this.div(n, n, n);
  }

  @Override
  @NonNull Vector3d abs();

  @Override
  @NonNull Vector3d ceil();

  @Override
  @NonNull Vector3d floor();

  @Override
  @NonNull Vector3d negate();

  @Override
  @NonNull Vector3d normalize();

  @Override
  @NonNull Vector3d pow(final double power);

  @Override
  @NonNull Vector3d round();

  @Override
  default double lengthSquared() {
    final double x = this.x();
    final double y = this.y();
    final double z = this.z();
    return x * x + y * y + z * z;
  }

  default @NonNull Vector3d minimum(final @NonNull Vector3d that) {
    return this.map(that, Math::min);
  }

  default @NonNull Vector3d maximum(final @NonNull Vector3d that) {
    return this.map(that, Math::max);
  }

  @Override
  default @NonNull DoubleStream stream() {
    return DoubleStream.of(this.x(), this.y(), this.z());
  }

  @Override
  @NonNull Vector3d map(final @NonNull DoubleUnaryOperator operator);

  @NonNull Vector3d map(final @NonNull Vector3d that, final @NonNull DoubleBinaryOperator operator);

  @NonNull Vector3d map(final @NonNull DoubleUnaryOperator x, final @NonNull DoubleUnaryOperator y, final @NonNull DoubleUnaryOperator z);

  @Override
  default boolean allMatch(final @NonNull DoublePredicate predicate) {
    return predicate.test(this.x()) && predicate.test(this.y()) && predicate.test(this.z());
  }

  @Override
  default boolean anyMatch(final @NonNull DoublePredicate predicate) {
    return predicate.test(this.x()) || predicate.test(this.y()) || predicate.test(this.z());
  }

  @Override @NonNull Vector3d copy();

  default boolean equals(final @Nullable Vector3d that) {
    return that != null
      && this.x() == that.x()
      && this.y() == that.y()
      && this.z() == that.z();
  }

  default double dot(Vector3d other) {
    return this.x() * other.x() + this.y() * other.y() + this.z() * other.z();
  }
}
