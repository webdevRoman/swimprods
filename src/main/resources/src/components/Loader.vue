<template lang="pug">
.loader
  .loader__animation
    .loader__circle
    .loader__circle
    .loader__circle
  .loader__title {{ title }}
</template>

<script>
export default {
  name: 'Loader',
  props: ['title']
}
</script>

<style scoped lang="stylus">
@import '../styles/vars'

.loader
  &__animation
    position relative
    width 50px
    height 50px
    margin 0 auto 20px auto
  &__circle
    position absolute
    top 0
    left 0
    width 20px
    height 20px
    border-radius 50%
    border 2px solid $cFontDark
    animation: circle-animation  3.6s infinite ease-in-out
    &:nth-child(2)
      animation-delay: -1.2s
    &:last-child
      animation-delay: -2.4s
  &__title
    font-size 18px
    animation: blink  1.8s infinite ease-in-out

@keyframes circle-animation
  from, 87.5%, to
    transform translate(0, 0)
  12.5%, 25%
    transform translate(0, 30px)
  37.5%, 50%
    transform translate(30px, 30px)
  62.5%, 75%
    transform translate(30px, 0)
@keyframes blink
  from, to
    opacity 1
  50%
    opacity 0.5
</style>