Usage:

Maven install and run the application, everything should work well.

Switch from `without-effect.uml` to `with-effect.uml`, and rerun the application. Some exception would be thrown and the state machine could not be generated successfully.

Compare `without-effect.uml` and `with-effect.uml`, the only difference is the following snippet:
```
<effect xmi:type="uml:OpaqueBehavior" xmi:id="_wAow4BvGEeuTMafLMVWT9w">
    <language>spel</language>
    <body>extendedState.variables.put('key','value')</body>
</effect>
```