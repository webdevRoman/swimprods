<template lang="pug">
.manufacturer
  .title Производитель
  Loader(title="Производим товар...", v-if="isProducing")
  button.btn(:disabled="isProducing", @click.prevent="produceProduct") Произвести товар
</template>

<script>
import Loader from './Loader.vue'

export default {
  name: 'Manufacturer',
  components: {
    Loader
  },
  methods: {
    produceProduct() {
      this.$store.dispatch('PRODUCE_PRODUCT')
    }
  },
  computed: {
    isProducing() {
      return this.$store.getters.isProducing
    }
  },
  created() {
    setInterval(() => {
      this.$store.dispatch('CHECK_NEW_PRODUCT')
    }, 1000)
  }
}
</script>