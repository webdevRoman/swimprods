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
  data() {
    return {
      isProducing: false
    }
  },
  methods: {
    produceProduct() {
      this.$store.dispatch('PRODUCE_PRODUCT')
      // .then(() => console.log('finished producing'))
    }
  }
  // computed: {
  //   count() {
  //     return this.$store.getters.count
  //   }
  // }
}
</script>