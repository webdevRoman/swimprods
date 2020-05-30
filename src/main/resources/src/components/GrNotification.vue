<template lang="pug">
.gr-notification
  button.gr-notification__close(@click="closeNotification")
  .gr-notification__header(v-if="grNotificationConfig.title")
    .gr-notification__title {{ grNotificationConfig.title }}
    .gr-notification__icon
      svg(v-if="grNotificationConfig.type === 'info'", width="20", height="20", viewBox="0 0 20 20", fill="none", xmlns="http://www.w3.org/2000/svg")
        path(fill-rule="evenodd", clip-rule="evenodd", d="M20 10C20 15.5228 15.5228 20 10 20C4.47715 20 0 15.5228 0 10C0 4.47715 4.47715 0 10 0C15.5228 0 20 4.47715 20 10ZM10 3C10.5523 3 11 3.44772 11 4V12C11 12.5523 10.5523 13 10 13C9.44771 13 9 12.5523 9 12V4C9 3.44772 9.44772 3 10 3ZM10 17C10.5523 17 11 16.5523 11 16C11 15.4477 10.5523 15 10 15C9.44772 15 9 15.4477 9 16C9 16.5523 9.44772 17 10 17Z", fill="#EEEEEE")
      svg(v-if="grNotificationConfig.type === 'success'", width="20", height="20", viewBox="0 0 20 20", fill="none", xmlns="http://www.w3.org/2000/svg")
        path(d="M10 0C4.48578 0 0 4.48578 0 10C0 15.5142 4.48578 20 10 20C15.5142 20 20 15.5142 20 10C20 4.48578 15.5142 0 10 0ZM15.0684 7.88086L9.65164 13.2974C9.48914 13.4599 9.27582 13.5417 9.0625 13.5417C8.84918 13.5417 8.63586 13.4599 8.47336 13.2974L5.76508 10.5891C5.43915 10.2634 5.43915 9.73663 5.76508 9.41086C6.09085 9.08493 6.61743 9.08493 6.94336 9.41086L9.0625 11.53L13.8901 6.70258C14.2159 6.37665 14.7424 6.37665 15.0684 6.70258C15.3941 7.02835 15.3941 7.55493 15.0684 7.88086Z", fill="#4DBA87")
      svg(v-if="grNotificationConfig.type === 'error'", width="20", height="20", viewBox="0 0 20 20", fill="none", xmlns="http://www.w3.org/2000/svg")
        path(fill-rule="evenodd", clip-rule="evenodd", d="M0 10C0 4.48578 4.48578 0 10 0C15.5142 0 20 4.48578 20 10C20 15.5142 15.5142 20 10 20C4.48578 20 0 15.5142 0 10ZM13.6826 13.6826C14.0083 13.3566 14.0083 12.8301 13.6826 12.5041L11.1783 10L13.6826 7.49589C14.0083 7.16996 14.0083 6.64338 13.6826 6.31745C13.3566 5.99168 12.8301 5.99168 12.5041 6.31745L10 8.82172L7.49589 6.31745C7.16996 5.99168 6.64338 5.99168 6.31745 6.31745C5.99168 6.64338 5.99168 7.16996 6.31745 7.49589L8.82172 10L6.31745 12.5041C5.99168 12.8301 5.99168 13.3566 6.31745 13.6826C6.47996 13.8451 6.69328 13.9267 6.90675 13.9267C7.12006 13.9267 7.33338 13.8451 7.49589 13.6826L10 11.1783L12.5041 13.6826C12.6666 13.8451 12.88 13.9267 13.0933 13.9267C13.3067 13.9267 13.5201 13.8451 13.6826 13.6826Z", fill="#FC5C65")
  .gr-notification__message(v-if="grNotificationConfig.message") {{ grNotificationConfig.message }}
</template>

<script>
export default {
  name: 'GrNotification',
  props: ['grNotificationConfig'],
  methods: {
    closeNotification() {
      const notification = document.getElementById(this.$attrs.id)
      notification.style.opacity = '0'
      setTimeout(() => { notification.style.display = 'none' }, 200)
      this.$store.dispatch('SET_ERROR', '')
    }
  }
}
</script>

<style scoped lang="stylus">
@import './../styles/vars'

.gr
  &-notification
    position: fixed
    bottom: 20px
    right: 20px
    display: none
    opacity: 0
    width: 400px
    padding: 10px 20px
    background-color: $cBgDark
    box-shadow: 0 0 20px rgba(0, 0, 0, .3)
    color: $cFontLight
    transition: .2s
    z-index: 10
    // @media screen and (max-width: $wL)
    // bottom 10px
    // right 10px
    // width 300px
    &__close
      position: absolute
      top: -40px
      right: 0
      width 30px
      height 30px
      transition: .2s
      &:after, &:before
        position absolute
        top 50%
        left 50%
        content ''
        display block
        width 100%
        height 2px
        background-color: $cBgDark
      &:before
        transform translate(-50%, -50%) rotate(45deg)
      &:after
        transform translate(-50%, -50%) rotate(-45deg)
      // @media screen and (max-width: $wL)
      // top -35px
      // font-size 28px
      &:hover
        transform: rotate(90deg)
        // @media screen and (max-width: $wL)
        // transform none
    &__header
      display: flex
      justify-content: space-between
      align-items: center
      margin-bottom: 15px
      // @media screen and (max-width: $wL)
      // margin-bottom 10px
    &__icon
      flex-shrink: 0
      width: 20px
      height: 20px
      margin-left: 10px
      svg
        width: 100%
        height: 100%
    &__message
      font-size: 14px
      line-height: 1.5
      // @media screen and (max-width: $wM)
      // font-size 12px
</style>