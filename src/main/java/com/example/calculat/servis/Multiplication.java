package com.example.calculat.servis;

import org.springframework.stereotype.Service;

@Service
public class Multiplication implements DoubleBinaryOperator {

  @Override
  public double apply(double num1, double num2) {
    return num1 * num2;
  }
}
