Паттерн - образ, способ того, как мы будем реализовывать ту или иную задачу. Паттерны предлагают нам ряд приницпов для решения проблем при проектированиии.
Выбрала три паттерна: 

1.Factory - реализовала в категориях. Создала класс CategoryFactory, который предполагает создание новой категории. Этот паттерн удобно применить, т.к. вполне возможно, что появятся новые названия категорий товара, и мы будем создавать новые объекты категорий, не создавая новых классов.

2.Singleton - реализовала в классе Store. Этот паттерн гарантирует, что у нас будет единственный экземпляр класса и невозможно будет создать другой магазин.

3.Command - реализовалаа в пакете commands. Этот паттерн позволяет инкасулировать запрос на выполнение определенного действия. Я размышляла над тем, чтобы улучшить программу в мейне, которая была у меня написана через сканнер и while c if. Применить паттерн команда показалось логичным - создавать объекты команд для больше подходить под концепцию ООП, я смогу добавлять команды непосредствено в классы команд, и таким образом main будет выглядеть более лаконично.

# 5. Patterns

## Materials

[Patterns](https://refactoring.guru/design-patterns)

## VideoLectures
- [Patterns(part 1)](https://youtu.be/q5U92-p-a0s)
- [Patterns(part 2)](https://youtu.be/bR7M\_lv52S4)

## Task #5
Read all materials, try to find a `proper` place to your newly learned patterns in our app. There are a lot of design patterns, but we advise you to pay attention to the following ones:
- Singleton;
- ChainOfResponsibility;
- Fabric.
The application of patterns consists not only in their implementation, but also in knowing their weaknesses and strengths. Therefore, in addition to realising the selected design patterns in the code, you must write the following justification for each pattern (you can send it to me in the messenger, or you can add text to README.md): 
- What is the Design Pattern? 
- Where did you apply it? 
- Justify why you chose this one and not another. What do you gain by using chosen Design Pattern?
## Hints
Rethink your application from SOLID point of view. Keep in mind that in addition to implementing multithreading, we will also work with the database and http. In many ways, we will repeat what we did for the console application for both the database and the http layers. It might be worth coming up with some common interfaces that different versions will implement.
