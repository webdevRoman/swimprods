<template lang="pug">
.customer
  .title Потребитель
  Loader(title="Потребляем товар...", v-if="isConsuming")
  button.btn(:disabled="isConsuming", @click.prevent="consumeProduct") Потребить товар
</template>

<script>
import Loader from './Loader.vue'

export default {
  name: 'Customer',
  components: {
    Loader
  },
  methods: {
    consumeProduct() {
      this.$store.dispatch('CONSUME_PRODUCT')
    }
  },
  computed: {
    isConsuming() {
      return this.$store.getters.isConsuming
    }
  },
  created() {
    setInterval(() => {
      this.$store.dispatch('CHECK_CONSUMED_PRODUCT')
    }, 1000)
  }
}
</script>

<style scoped lang="stylus">
.customer
  flex-basis: 30%
</style>