# Parallel_prog

**"Паралельні та розподілені обчислення"**
**"Паралельне програмування -1. Основи паралельного програмування"**


**Лабораторная работа N 1. ПОТОКИ В ЯЗЫКЕ АДА.ЗАДАЧИ**
 
**Цель работы:** изучение средств языка Ада для работы с процессами (потоками).
 
**Выполнение работы:** Разработать программу, содержащую   параллельные потоки (задачи), каждый из которых реализует функцию F1, F2, F3 из Приложения Б согласно полученному варианту.

Программа  должна состоять из  пакета Data и основной программы – процедуры Lab1.  Пакет реализует ресурсы, необходимые для вычисления функций F1, F2, F3 через  подпрограммы Func1, Func2, Func3.
 
При разработке процедур следует разделять формальные параметры  на входные (in) и выходные (out). Следует изучить команды и опции компилятора  ObjectAda, необходимые для компиляции и редактирования связей программы. 
  
Пакет  Data  включает следующие  ресурсы: 
-   подпрограммы Func1, Func2, Func3 
-   необходимые  т и п ы  (например, Vector и Matrix ) 
-   дополнительные процедуры  ввода/вывода (Vector_Input, Vector_Output, Matrix_Input, Matrix_Output).

 Для получения высокого балла по лабораторной работе 1 следует использовать   л и ч н ы й  (private) тип при проектировании пакета  Data и показать особенности  его  использования. Еще более высокий балл обеспечивает разработка  и использование пакета Data  как настраиваемого (generic) пакета. 
 
 При создании задач необходимо: 
 - указать имя задачи 
 - задать приоритет задачи 
 - задать размер стека для задачи 
 -  выбрать и  задать номер процессора (ядра) для  выполнения каждой задачи. 
 
  Первый и последний операторы  тела задачи выводят на экран информацию о старте и завершении соответствующей задачи (“Task T1  started”, “ Task T2 finished”). 
  
  В теле задачи использовать оператор  задержки delay, поставив его перед и после выполнения функции F1, F2, F3 с небольшим временем задержки. 
  
   Исследовать при выполнении программы: 
   -  влияние  приоритетов задач на очередность запуска задач (при использовании одного или двух ядер).  
   -  влияние  оператора задержки delay на  порядок выполнения задач.  
   - загрузку параллельной компьютерной  системы (ПКС) ( ядер процессора) при изменении их количества. Изменение количества ядер  задается с помощью Менеджера (Диспетчера) задач  ОС  Windows.
   
   
**Лабораторная работа N 2. ПОТОКИ  В ЯЗЫКЕ JAVA**
 
**Цель работы:** изучение средств языка Java для работы с потоками (процессами). 

**Выполнение работы:**  Разработать программу, содержащую   параллельные потоки, каждый из которых реализует функцию F1, F2, F3.
  
Требования к созданию потоков и необходимые исследования программы описаны в лабораторной работе 1. 

В потоках использовать методы  sleep()  и join(). 

Создаваемый поток должен переопределять метод run(), который определяет действия  данного потока при выполнении. При создании экземпляра касса – потока следует использовать соответствующий конструктор, с помощью которого   задать внутренне имя потока, его приоритет, особенности поведения и др. 
 
 
**Лабораторная работа N 3. ПОТОКИ  В ЯЗЫКЕ С#**
 
**Цель работы:** изучение средств языка C# для работы с потоками (процессами). 

**Выполнение работы:**  Разработать программу, содержащую   параллельные потоки, каждый из которых реализует функцию F1, F2, F3. 

Требования к созданию потоков и необходимые исследования программы описаны в лабораторной работе 1.


**Лабораторная работа N 4. ПОТОКИ  В БИБЛИОТЕКЕ WIN32**
 
**Цель работы:** изучение средств библиотеки Win32 для работы с потоками (процессами). 

**Выполнение работы:**  Разработать программу, содержащую   параллельные потоки, каждый из которых реализует функцию F1, F2, F3.

Требования к созданию потоков и необходимые исследования программы описаны в лабораторной работе 1.


**Лабораторная работа N 5. ПОТОКИ В БИБЛИОТЕКЕ OpenMP**
 
**Цель работы:** изучение средств библиотеки OpenMP для работы с задачами (процессами). 

**Выполнение работы:**  Разработать программу, содержащую   параллельные потоки, каждый из которых реализует функцию F1, F2, F3.  

Требования к созданию потоков и необходимые исследования программы описаны в лабораторной работе 1.


**Лабораторная работа N 6. ПОТОКИ В БИБЛИОТЕКЕ MPI**
 
**Цель работы:** изучение средств библиотеки MPI для работы с задачами (процессами). 

**Выполнение работы:**  Разработать программу, содержащую   параллельные  потоки, каждый из которых реализует функцию F1, F2, F3.  

Требования к созданию потоков и необходимые исследования программы описаны в лабораторной работе 1.