package com.example.calculat.controller;

import com.example.calculat.servis.Difference;
import com.example.calculat.servis.Multiplication;
import com.example.calculat.servis.Quotient;
import com.example.calculat.servis.Sum;
import io.swagger.annotations.ApiOperation;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class SimpleOperationController {

  private Sum sum;
  private Quotient quotient;
  private Difference difference;
  private Multiplication multiplication;

  public SimpleOperationController(Sum sum, Quotient quotient,
      Difference difference, Multiplication multiplication) {
    this.sum = sum;
    this.quotient = quotient;
    this.difference = difference;
    this.multiplication = multiplication;
  }

  @GetMapping
  @ApiOperation("Страничка приветствия")
  public String printHello() {
    return "<b>Добро пожаловать в калькулятор.<b>";
  }

  @GetMapping("/sum")
  @ApiOperation("Получение суммы чисел")
  public String getSumNumbers(@RequestParam double num1, double num2) {
    return num1 + "+" + num2 + "=" + sum.apply(num1, num2);
  }

  @GetMapping("/dif")
  @ApiOperation("Получение разницы чисел")
  public String getDifferenceNumbers(@RequestParam double num1, double num2) {
    return num1 + "-" + num2 + "=" + difference.apply(num1, num2);
  }

  @GetMapping("/multi")
  @ApiOperation("Получение произведения чисел")
  public String dfNumbers(@RequestParam double num1, double num2) {
    return num1 + "*" + num2 + "=" + multiplication.apply(num1, num2);
  }

  @GetMapping("/quoit")
  @ApiOperation("Получение частного чисел")
  public String deNumbers(@RequestParam double num1, double num2) {
    if (num2 == 0) {
      throw new ArithmeticException("Divide by zero error");
    }
    return num1 + "/" + num2 + "=" + quotient.apply(num1, num2);
  }
}
