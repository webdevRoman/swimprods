<template lang="pug">
.app
  .header Swim Prods
  .main
    Manufacturer.main__section
    Warehouse.main__section
    Customer.main__section
</template>

<script>
import Manufacturer from './components/Manufacturer.vue'
import Warehouse from './components/Warehouse.vue'
import Customer from './components/Customer.vue'

export default {
  name: 'App',
  components: {
    Manufacturer,
    Warehouse,
    Customer
  },
  data() {
    return {
      sections: ['manufacturer', 'warehouse', 'customer']
    }
  }
}
</script>

<style lang="stylus">
@import './styles/vars'
@import './styles/reset'

html, button
  font-family: $font
  color: $cFontDark
body
  background-color $cBgLight
  overflow-x: hidden

.app
  width 100vw
  height 100vh
  display flex
  flex-direction column
.header
  padding 5px 0
  background-color #E8E8E8
  font-size 36px
  font-weight bold
  letter-spacing 5px
  text-transform uppercase
  text-align center
  color #006064
.main
  flex-grow 1
  display flex
  justify-content space-between
  &__section
    flex-basis 33%
    border-right 5px solid #E8E8E8
    display flex
    justify-content space-between
    align-items center
    flex-direction column
    padding 10px 0
    &:last-child
      border-right none

.title
  font-size 18px
  text-transform uppercase
.btn
  width 90%
  padding 10px
  background-color $cActive
  color $cFontLight
  text-transform uppercase
  transition 0.2s
  &:hover
    background-color darken($cActive, 10)
  &[disabled]
    opacity 0.5
    &:hover
      background-color $cActive
</style>